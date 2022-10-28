class Solution {
    int x[] = {-1, 1, 0, 0};
    int y[] = {0, 0, -1, 1};
    public void solve(char[][] board) {
        int rows = board.length;
        int cols = board[0].length;
        int[][] status = new int[rows][cols];
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(board[i][j] == 'O' && status[i][j] == 0){
                    dfs(board, i, j, status);
                }
            }
        }
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(board[i][j] == 'O' && status[i][j] != 2){
                    board[i][j] = 'X';
                }
            }
        }
    }

    public void dfs(char[][] board, int row, int col, int[][] status) {
        status[row][col] = 1;
        if(row == 0 || col == 0 || row == board.length - 1 || col == board[0].length - 1){
            change(board, row, col, status);
        }
        for(int i = 0; i < 4; i++){
            int rr = row + y[i];
            int cc = col + x[i];
            if(rr > 0 && cc > 0 && rr < board.length && cc < board[0].length && board[rr][cc] == 'O' && status[rr][cc] == 0){
                dfs(board, rr, cc, status);
            }
        }
    }

    public void change(char[][] board, int row, int col, int[][] status){
        status[row][col] = 2;
        for(int i = 0; i < 4; i++){
            int rr = row + y[i];
            int cc = col + x[i];
            if(rr > 0 && cc > 0 && rr < board.length && cc < board[0].length && board[rr][cc] == 'O' && (status[rr][cc] == 0 || status[rr][cc] == 1)){
                change(board, rr, cc, status);
            }
        }
    }
}