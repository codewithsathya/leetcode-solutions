class Solution {
    public int maximalSquare(char[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] largest = new int[rows][cols];
        int max = 0;
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                largest[i][j] = matrix[i][j] == '1' ? 1 : 0;
                max = Math.max(max, largest[i][j]);
            }
        }
        for(int i = 1; i < rows; i++){
            for(int j = 1; j < cols; j++){
                int a = largest[i - 1][j];
                int b = largest[i - 1][j - 1];
                int c = largest[i][j - 1];
                int curr = largest[i][j];
                if(curr > 0){
                    int min = Math.min(a, Math.min(b, c));
                    largest[i][j] = curr + min;
                }
                max = Math.max(max, largest[i][j]);
            }
        }
        return max * max;
    }
}