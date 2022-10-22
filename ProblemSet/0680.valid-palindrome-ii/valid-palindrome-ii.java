class Solution {
    public boolean validPalindrome(String s) {
        int low = 0;
        int high = s.length() - 1;
        while(low <= high){
            if(s.charAt(low) == s.charAt(high)){
                low++;
                high--;
            }else{
                if(s.charAt(low) == s.charAt(high - 1) && s.charAt(low + 1) == s.charAt(high)){
                    String str1 = s.substring(0, high) + s.substring(high + 1);
                    String str2 = s.substring(0, low) + s.substring(low + 1);
                    return isPalindrome(str1) || isPalindrome(str2);
                }else if(s.charAt(low) == s.charAt(high - 1)){
                    // remove high character
                    String newStr = s.substring(0, high) + s.substring(high + 1);
                    return isPalindrome(newStr);
                }else if(s.charAt(low + 1) == s.charAt(high)){
                    // remove low character
                    String newStr = s.substring(0, low) + s.substring(low + 1);
                    return isPalindrome(newStr);
                }else{
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isPalindrome(String str){
        int low = 0;
        int high = str.length() - 1;
        while(low < high){
            if(str.charAt(low) != str.charAt(high)){
                return false;
            }
            low++;
            high--;
        }
        return true;
    }
}