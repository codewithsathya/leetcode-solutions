class Solution {
    public boolean isPalindrome(int x) {
      int y = x;
      if(x < 0) return false;
      int rev = 0;
      while(x != 0) {
        int pop = x % 10;
        x /= 10;
        rev = rev * 10 + pop;
      }
      if(y == rev) return true;
      return false;
    }
}