class Solution {
    public String longestPalindrome(String s) {
        if(s == null || s.length() == 0) return "";
        int start = 0;
        int end = 0;
        for(int i = 0; i < s.length(); i++){
            int len = Math.max(sizeOfPalindrome(s, i, i), sizeOfPalindrome(s, i, i + 1));
            if(end - start < len){
                end = i + len / 2;
                start = i - (len - 1) / 2;
            }
        }
        return s.substring(start, end + 1);
    }
    
    public int sizeOfPalindrome(String s, int left, int right){
        if(s == null || left > right) return 0; 
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }
        return right - left - 1;
    }
}