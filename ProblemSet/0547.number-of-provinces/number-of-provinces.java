class Solution {
    public int findCircleNum(int[][] isConnected) {
        int len = isConnected.length;
        boolean[] visited = new boolean[len];
        int count = 0;
        for(int i = 0; i < len; i++){
            if(!visited[i]){
                dfs(isConnected, visited, i);
                count++;
            }
        }
        return count;
    }

    void dfs(int[][] graph, boolean[] visited, int curr){
        visited[curr] = true;
        for(int i = 0; i < graph.length; i++){
            if(curr == i) continue;
            if(!visited[i] && graph[curr][i] == 1){
                dfs(graph, visited, i);
            }
        }
    }
}