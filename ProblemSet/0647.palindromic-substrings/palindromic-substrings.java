class Solution {
    public int countSubstrings(String s) {
        int len = s.length();
        if(len == 1) return 1;
        int count = 0;
        for(int i = 0; i < len; i++){
            int count1 = countSubstrings(s, i, i);
            int count2 = countSubstrings(s, i, i + 1);
            count += count1 + count2;
        }
        return count;
    }
    
    public int countSubstrings(String s, int left, int right){
        if(s == null || left > right) return 0;
        int count = 0;
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
            count++;
        }
        return count;
    }
    
}