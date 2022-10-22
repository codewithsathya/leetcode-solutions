class Solution {
    static int[] x = {1, -1, 0, 0};
    static int[] y = {0, 0, 1, -1};
    Map<Integer, Map<Integer, Integer>> memo = new HashMap<>();
    public int bfs(int[][] matrix, int row, int col){
        if(memo.containsKey(row) && memo.get(row).containsKey(col)){
            return memo.get(row).get(col);
        }
        int max = 0;
        for(int i = 0; i < 4; i++){
            int rr = row + y[i];
            int cc = col + x[i];
            if(rr >= matrix.length || cc >= matrix[0].length || rr < 0 || cc < 0){
                continue;
            }
            if(matrix[rr][cc] <= matrix[row][col]){
                continue;
            }
            max = Math.max(max, bfs(matrix, rr, cc));
        }
        memo.putIfAbsent(row, new HashMap<>());
        memo.get(row).put(col, max + 1);
        return max + 1;
    }

    public int longestIncreasingPath(int[][] matrix) {
        int max = 0;
        for(int row = 0; row < matrix.length; row++){
            for(int col = 0; col < matrix[0].length; col++){
                max = Math.max(max, bfs(matrix, row, col));
            }
        }
        return max;
    }
}