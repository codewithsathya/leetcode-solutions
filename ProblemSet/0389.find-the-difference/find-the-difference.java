class Solution {
    public char findTheDifference(String s, String t) {
        int[] chars = new int[26];
        for(char ch: t.toCharArray()){
            chars[ch - 97]++;
        }
        for(char ch: s.toCharArray()){
            chars[ch - 97]--;
        }
        for(int i = 0; i < 26; i++){
            if(chars[i] == 1){
                return (char)(i + 97);
            }
        }
        return ' ';
    }
}