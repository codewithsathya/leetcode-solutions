class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        if(m == 0){
            return n;
        }
        if(n == 0){
            return m;
        }
        int[][] table = new int[m + 1][n + 1];
        for(int i = 0; i < m + 1; i ++){
            table[i][0] = i;
        }
        for(int j = 0; j < n + 1; j++){
            table[0][j] = j;
        }
        for(int i = 1; i < m + 1; i++){
            for(int j = 1; j < n + 1; j++){
                int cost = 0;
                if(word1.charAt(i - 1) != word2.charAt(j - 1)){
                    cost = 1;
                }
                table[i][j] = Math.min(Math.min(table[i - 1][j] + 1, table[i][j - 1] + 1), table[i - 1][j - 1] + cost);
            }
        }
        return table[m][n];
    }
}