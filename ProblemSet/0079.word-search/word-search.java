class Solution {
    public boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(helper(i, j, board, word, 0, "", new HashMap<>())) return true;
            }
        }
        return false;
    }

    public boolean helper(int row, int col, char[][] board, String word, int index, String cons, Map<Integer, Set<Integer>> visited){
        if(board[row][col] != word.charAt(index) || (visited.containsKey(row) && visited.get(row).contains(col))) return false;

        cons = cons + board[row][col];
        if(cons.equals(word)) return true;

        visited.putIfAbsent(row, new HashSet<>());
        visited.get(row).add(col);
        int[] x = {1, -1, 0, 0};
        int[] y = {0, 0, 1, -1};

        for(int i = 0; i < 4; i++){
            int rr = row + y[i];
            int cc = col + x[i];
            if(rr < 0 || rr >= board.length || cc < 0 || cc >= board[0].length)
                continue;
            if(helper(rr, cc, board, word, index + 1, cons, visited)) return true;
        }
        visited.get(row).remove(col);
        return false;
    }
}