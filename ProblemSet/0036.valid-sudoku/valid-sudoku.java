class Solution {
    public boolean isValidSudoku(char[][] board) {
        for(int row = 0; row < board.length; row++){
            HashSet<Character> hset = new HashSet<>();
            for(char ch: board[row]){
                if(ch == '.') continue;
                if(hset.contains(ch))
                    return false;
                hset.add(ch);
            }
        }
        for(int col = 0; col < board[0].length; col++){
            HashSet<Character> hset = new HashSet<>();
            for(int row = 0; row < board.length; row++){
                char ch = board[row][col];
                if(ch == '.') continue;
                if(hset.contains(ch))
                    return false;
                hset.add(ch);
            }
        }
        for(int row = 0; row < 3; row++){
            for(int col = 0; col < 3; col++){
                HashSet<Character> hset = new HashSet<>();
                for(int i = 0; i < 3; i++){
                    for(int j = 0; j < 3; j++){
                        char ch = board[3 * row + i][3 * col + j];
                        if(ch == '.') continue;
                        if(hset.contains(ch))
                            return false;
                        hset.add(ch);
                    }
                }
            }
        }
        return true;
    }
}