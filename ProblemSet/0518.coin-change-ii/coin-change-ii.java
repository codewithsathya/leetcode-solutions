class Solution {
    public int change(int amount, int[] coins) {
        int[][] arr = new int[coins.length][amount + 1];
        for(int i = 0; i < coins.length; i++){
            arr[i][0] = 1;
        }
        for(int row = coins.length - 1; row >= 0; row--){
            for(int col = 1; col <= amount; col++){
                if(col - coins[row] < 0){
                    if(row + 1 > coins.length - 1){
                        arr[row][col] = 0;
                    }else{
                        arr[row][col] = arr[row + 1][col];
                    }
                }else{
                    if(row + 1 > coins.length - 1){
                        arr[row][col] = arr[row][col - coins[row]];
                    }else{
                        arr[row][col] = arr[row][col - coins[row]] + arr[row + 1][col];
                    }
                }
            }
        }
        return arr[0][amount];
    }
}