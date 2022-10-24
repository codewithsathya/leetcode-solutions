class Solution {
    public String customSortString(String order, String s) {
        String[] strs = new String[26];
        int charStart = 97;
        Arrays.fill(strs, "");
        for(char ch: s.toCharArray()){
            strs[ch - charStart] += ch;
        }
        String res = "";
        for(char ch: order.toCharArray()){
            if(strs[ch - charStart].length() != 0){
                res += strs[ch - charStart];
                strs[ch - charStart] = "";
            }
        }
        for(String str: strs){
            if(str.length() != 0){
                res += str;
            }
        }
        return res;
    }
}