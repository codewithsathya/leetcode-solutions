class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int rows = dungeon.length;
        int cols = dungeon[0].length;
        int[][] dp = new int[rows][cols];
        for (int i = rows - 1; i >= 0; --i) {
            for (int j = cols - 1; j >= 0; --j) {
                int right = 0, bottom = 0;
                if (j + 1 < cols) {
                    right = dp[i][j + 1];
                }
                if (i + 1 < rows) {
                    bottom = dp[i + 1][j];
                }
                int req = Integer.MAX_VALUE;
                if(j + 1 == cols && i + 1 == rows){
                    if(dungeon[i][j] < 0){
                        dp[i][j] = -dungeon[i][j] + 1;
                    }else{
                        dp[i][j] = 1;
                    }
                    continue;
                }
                if (j + 1 < cols)
                    if (right == 0 && dungeon[i][j] < 0) {
                        req = -dungeon[i][j] + 1;
                    } else {
                        req = right - dungeon[i][j];
                        if(req < 1){
                            req = 1;
                        }
                    }
                
                if(i + 1 < rows){
                    if(bottom == 0 && dungeon[i][j] < 0){
                        req  = Math.min(req, -dungeon[i][j] + 1);
                    }else{
                        req = Math.min(req, bottom - dungeon[i][j]);
                        if(req < 1){
                            req = 1;
                        }
                    }
                }
                dp[i][j] = req;
            }
        }
        return dp[0][0];
    }
}