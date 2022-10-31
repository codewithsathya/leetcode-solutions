class Solution {
    int[] x = {1, -1, 0, 0};
    int[] y = {0, 0, 1, -1};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int rows = heights.length;
        int cols = heights[0].length;
        int[][] status = new int[rows][cols];
        List<List<Integer>> result = new ArrayList<>();
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                dfs(heights, new boolean[rows][cols], i, j, status, i, j);
                if(status[i][j] == 3){
                    List<Integer> list = new ArrayList<>();
                    list.add(i);
                    list.add(j);
                    result.add(list);
                }
            }
        }
        return result;
    }

    public void dfs(int[][] heights, boolean[][] visited, int row, int col, int[][] status, int mainRow, int mainCol){
        visited[row][col] = true;
        /*
         * 0 no ocean visited
         * 1 pacific ocean visited
         * 2 atlantic ocean visited
         * 3 both oceans visited
         */
        if(status[mainRow][mainCol] == 3){
            return;
        }
        if(row == 0 || col == 0){
            if(status[mainRow][mainCol] == 2){
                status[mainRow][mainCol] = 3;
                return;
            }else if(status[mainRow][mainCol] == 0){
                status[mainRow][mainCol] = 1;
            }
        }

        if(row == heights.length - 1 || col == heights[0].length - 1){
            if(status[mainRow][mainCol] == 1){
                status[mainRow][mainCol] = 3;
                return;
            }else if(status[mainRow][mainCol] == 0){
                status[mainRow][mainCol] = 2;
            }
        }

        for(int i = 0; i < 4; i++){
            int rr = row + x[i];
            int cc = col + y[i];
            if(rr >= 0 && rr < heights.length && cc >= 0 && cc < heights[0].length && !visited[rr][cc] && heights[rr][cc] <= heights[row][col]){
                dfs(heights, visited, rr, cc, status, mainRow, mainCol);
            }
        }
    }
}