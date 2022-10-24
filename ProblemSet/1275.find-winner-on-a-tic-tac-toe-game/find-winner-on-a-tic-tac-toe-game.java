class Solution {
    public String tictactoe(int[][] moves) {
        char[][] board = new char[3][3];
        for(int i = 0; i < moves.length; i++){
            int[] move = moves[i];
            board[move[0]][move[1]] = (i & 1) == 0 ? 'A' : 'B';
        }
        char[] characters = {'A', 'B'};
        for(char ch: characters){
            for(int row = 0; row < 3; row++){
                if(board[row][0] == ch && board[row][1] == ch && board[row][2] == ch){
                    return String.valueOf(ch);
                }
                if(board[0][row] == ch && board[1][row] == ch && board[2][row] == ch){
                    return String.valueOf(ch);
                }
                if(board[0][0] == ch && board[1][1] == ch && board[2][2] == ch){
                    return String.valueOf(ch);
                }
                if(board[0][2] == ch && board[1][1] == ch && board[2][0] == ch){
                    return String.valueOf(ch);
                }
            }
        }
        if(moves.length == 9){
            return "Draw";
        }
        return "Pending";
    }
}