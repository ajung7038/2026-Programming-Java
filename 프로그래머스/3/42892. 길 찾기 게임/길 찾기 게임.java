import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.lang.Math;
import java.util.Collections;

class Solution {
    public static int preIdx = 0;
    public static int postIdx = 0;
    public static int[][] result;
    public int[][] solution(int[][] nodeinfo) {
        
        result = new int[2][nodeinfo.length];
        Map<Integer, Node> nodeList = new HashMap<>();
        
        // 노드 만들기
        for (int i=0; i<nodeinfo.length; i++) {
            int x = nodeinfo[i][0];
            int y = nodeinfo[i][1];
            
            Node node = new Node(x, y, i+1);
            nodeList.put(x, node);
        }
        
        // nodeList도 정렬
        List<Node> nodeListValueSet = new ArrayList<>(nodeList.values());
        nodeListValueSet.sort((o1, o2) -> {
            return o1.y != o2.y ? o2.y - o1.y : o1.x - o2.x;
        });
        
        // root 설정
        Node root = nodeListValueSet.get(0);
        
        List<Integer> xList = new ArrayList<>(); // map으로 변경해도 괜찮나?
        for (Node node : nodeListValueSet) {
            int x = node.x;
            int y = node.y;
            
            // root인 경우
            if (xList.size() == 0) {
                xList.add(x);
                continue;
            }
            
            int rightXListIndex = xList.get(xList.size()-1);
            
            // 가장 왼쪽에 있는 경우
            if (x < xList.get(0)) {
                Node parent = nodeList.get(xList.get(0));
                parent.left = node;
                node.parent = parent;
            }
            // 가장 오른쪽에 있는 경우
            else if (x > rightXListIndex) {         
                Node parent = nodeList.get(rightXListIndex);
                parent.right = node;
                node.parent = parent;
            }
            // 노드 사이에 있는 경우
            else {
                int frontX = 0;
                int backX = 0;
                for (int i=0; i<xList.size(); i++) {
                    int vsX = xList.get(i);
                    if (x < vsX) {
                        backX = vsX;
                        frontX = xList.get(i-1);
                        break;
                    }
                }
            
                Node frontNode = nodeList.get(frontX);
                Node backNode = nodeList.get(backX);
            
                // 둘 중 y값이 작은 것이 부모
                if (frontNode.y < backNode.y) {
                    frontNode.right = node;
                    node.parent = frontNode;
                } else {
                    backNode.left = node;
                    node.parent = backNode;
                }                
            }
            // xList 추가 및 정렬
            xList.add(x);
            Collections.sort(xList); // 오름차순 정렬
        }
        
        boolean[] visited = new boolean[nodeinfo.length];
        circuit(root, visited);
        return result;
    }
    
    public static void circuit(Node node, boolean[] visited) {
        int idx = node.index;
        
        // 방문 여부 확인
        // if (visited[x]) return;
        // visited[x] = true;
        
        // 전위 순회 추가
        result[0][preIdx++] = idx;
        
        // 순회
        if (node.left != null) circuit(node.left, visited);
        if (node.right != null) circuit(node.right, visited);
        
        result[1][postIdx++] = idx;
    }
    
    
    public static class Node {
        int x;
        int y;
        int index;
        
        Node left;
        Node right;
        Node parent;
        
        public Node(int x, int y, int index) {
            this.x = x;
            this.y = y;
            this.index = index;
        }
    }
}