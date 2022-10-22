class Solution {
    boolean[][] visited;
    int[] x = {0, 0, 1, -1};
    int[] y = {1, -1, 0, 0};

    public int maxAreaOfIsland(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        visited = new boolean[rows][cols];
        int max = 0;
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(grid[i][j] == 1 && !visited[i][j]){
                    max = Math.max(max, dfs(i, j, grid));
                }
            }
        }
        return max;
    }
    
    public int dfs(int row, int col, int[][] grid){
        visited[row][col] = true;
        int area = 0;
        for(int i = 0; i < 4; i++){
            int rr = row + y[i];
            int cc = col + x[i];
            if(rr < 0 || rr >= grid.length || cc < 0 || cc >= grid[0].length || grid[rr][cc] == 0 || visited[rr][cc])
                continue;
            area += dfs(rr, cc, grid);
        }
        return area + 1;
    }
}