class Solution {
    int[] x = {0, 0, 1, -1};
    int[] y = {1, -1, 0, 0};
    public int numIslands(char[][] grid) {
        Map<Integer, Set<Integer>> visited = new HashMap<>();
        int count = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if((visited.containsKey(i) && visited.get(i).contains(j)) || grid[i][j] == '0') continue;
                dfs(grid, i, j, visited);
                count++;
            }
        }
        return count;
    }

    public void dfs(char[][] grid, int row, int col, Map<Integer, Set<Integer>> visited){
        visited.putIfAbsent(row, new HashSet<>());
        visited.get(row).add(col);
        for(int i = 0; i < 4; i++){
            int rr = row + y[i];
            int cc = col + x[i];
            if(rr < 0 || rr >= grid.length || cc < 0 || cc >= grid[0].length) continue;
            if((visited.containsKey(rr) && visited.get(rr).contains(cc)) || grid[rr][cc] == '0'){
                continue;
            }
            dfs(grid, rr, cc, visited);
        }
    }
}