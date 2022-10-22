class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length() + s2.length() != s3.length()) return false;
        boolean[][] arr = new boolean[s1.length() + 1][s2.length() + 1];
        arr[s1.length()][s2.length()] = true;
        for(int i = 0; i < s2.length(); i++){
            if(s2.charAt(i) == s3.charAt(s1.length() + i))
                arr[s1.length()][i] = true;
        }
        for(int i = 0; i < s1.length(); i++){
            if(s1.charAt(i) == s3.charAt(s2.length() + i))
                arr[i][s2.length()] = true;
        }
        for(int row = s1.length() - 1; row >= 0; row--){
            for(int col = s2.length() - 1; col >= 0; col--){
                if(s1.charAt(row) == s3.charAt(row + col) && s2.charAt(col) == s3.charAt(row + col)){
                    if(arr[row + 1][col] || arr[row][col + 1])
                        arr[row][col] = true;
                }else if(s1.charAt(row) == s3.charAt(row + col) && arr[row + 1][col]){
                    arr[row][col] = true;
                }else if(s2.charAt(col) == s3.charAt(row + col) && arr[row][col + 1]){
                    arr[row][col] = true;
                }
            }
        }
        return arr[0][0];
    }
}