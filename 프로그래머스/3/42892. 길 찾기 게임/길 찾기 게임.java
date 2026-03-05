import java.util.List;
import java.util.ArrayList;

class Solution {
    public int preIdx = 0;
    public int postIdx = 0;
    public int[][] result;
    
    public int[][] solution(int[][] nodeinfo) {
        // 노드 만들기
        List<Node> nodeList = new ArrayList<>();
        int idx = 1;
        for (int[] n : nodeinfo) {
            Node node = new Node(n[0], n[1], idx++);
            nodeList.add(node);
        }
        
        // 노드 정렬
        nodeList.sort((o1, o2) -> {
            return o1.y != o2.y ? o2.y - o1.y : o1.x - o2.x;
        });
        
        Node root = nodeList.get(0);
        nodeList.remove(0);
        // 간선 잇기
        for (Node node : nodeList) {
            addNode(root, node);
        }
       

        // 전위/후위 순회
        result = new int[2][nodeinfo.length];
        circuitNode(root);
        
        return result;
    }
    
    public void circuitNode(Node node) {
        // 전위 순회
        result[0][preIdx++] = node.index;
        if (node.left != null) circuitNode(node.left);
        if (node.right != null) circuitNode(node.right);
        // 후위 순회
        result[1][postIdx++] = node.index;
    }
    
    public void addNode(Node parent, Node node) {
        if (node.x < parent.x) {
            if (parent.left == null) parent.left = node;
            else addNode(parent.left, node);
        } else {
            if (parent.right == null) parent.right = node;
            else addNode(parent.right, node);
        }
    }
    
    public class Node {
        int x;
        int y;
        int index;
        Node left;
        Node right;
        
        public Node(int x, int y, int index) {
            this.x = x;
            this.y = y;
            this.index = index;
        }
    }
}