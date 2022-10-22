class Solution {
    private String reverse(String s){
        StringBuilder sb = new StringBuilder(s);
        sb.reverse();
        return sb.toString();
    }
    public String reverseWords(String s) {
        String[] st = s.split("\\s+");
        String result = "";
        for(int i = 0; i < st.length; i++){
            result += reverse(st[i]);
            if(i < st.length - 1){
                result += " ";
            }
        }
        return result;
    }
}