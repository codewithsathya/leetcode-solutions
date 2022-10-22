class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[][] table = new int[obstacleGrid.length][obstacleGrid[0].length];
        for(int[] row: table){
            Arrays.fill(row, 0);
        }
        if(obstacleGrid[0][0] == 1) return 0;
        table[0][0] = 1;
        for(int i = 0; i < obstacleGrid.length; i++){
            for(int j = 0; j < obstacleGrid[0].length; j++){
                if(obstacleGrid[i][j] == 1) continue;
                if(i - 1 >= 0){
                    table[i][j] += table[i - 1][j];
                }
                if(j - 1 >= 0){
                    table[i][j] += table[i][j - 1];
                }
            }
        }
        return table[obstacleGrid.length - 1][obstacleGrid[0].length - 1];
    }
}