class Solution {
    public int solution(int n, int[][] computers) {
        int count=0;
        boolean[] visited = new boolean[computers.length];
        for (int i=0; i<computers.length; i++) {
            // 방문하지 않았다면
            if (!visited[i]) {
                count++;
                dfs(visited, i, computers);
            }
        }
        
        return count;
    }
    
    public static void dfs(boolean[] visited, int node, int[][] computers) {
        // 종료 조건
        if (visited[node]) return;
        
        visited[node] = true;
        for (int i=0; i<computers.length; i++) {
            if (i == node) continue;
            if (computers[node][i] == 1) dfs(visited, i, computers);
        }
    }
}