class Solution {
    public int numRookCaptures(char[][] board) {
        int[] x = {1, -1, 0, 0};
        int[] y = {0, 0, 1, -1};
        int row = 0;
        int col = 0;
        boolean found = false;
        for(int i = 0; i < 7; i++){
            for(int j = 0; j < 7; j++){
                if(board[i][j] == 'R'){
                    found = true;
                    row = i;
                    col = j;
                    break;
                }
            }
            if(found) break;
        }
        int ans = 0;
        for(int i = 0; i < 4; i++){
            int crow = row;
            int ccol = col;
            while(true){
                crow += y[i];
                ccol += x[i];
                if(crow < 0 || crow > 7 || ccol < 0 || ccol > 7){
                    break;
                }
                if(board[crow][ccol] == 'B'){
                    break;
                }
                if(board[crow][ccol] == 'p'){
                    ans++;
                    break;
                }
            }
        }
        return ans;
    }
}