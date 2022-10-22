class Solution {
    static int[] x = {0, 0, 1, -1, 1, 1, -1, -1};
    static int[] y = {1, -1, 0, 0, 1, -1, 1, -1};
    public void populateOnes(int[][] board, int[][] noOfOnes){
        for(int[] row: noOfOnes){
            Arrays.fill(row, 0);
        }
        for(int row = 0; row < board.length; row++){
            for(int col = 0; col < board[0].length; col++){
                if(board[row][col] == 1)
                for(int i = 0; i < x.length; i++){
                    int rr = row + y[i];
                    int cc = col + x[i];
                    if(rr >= board.length || cc >= board[0].length || rr < 0 || cc < 0){
                        continue;
                    }
                    noOfOnes[rr][cc]++;
                }
            }
        }
    }

    public void gameOfLife(int[][] board) {
        int[][] noOfOnes = new int[board.length][board[0].length];
        populateOnes(board, noOfOnes);
        for(int row = 0; row < board.length; row++){
            for(int col = 0; col < board[0].length; col++){
                if(board[row][col] == 0 && noOfOnes[row][col] == 3){
                    board[row][col] = 1;
                }else if(board[row][col] == 1){
                    if(noOfOnes[row][col] < 2 || noOfOnes[row][col] > 3){
                        board[row][col] = 0;
                    }
                }
            }
        }
    }
}