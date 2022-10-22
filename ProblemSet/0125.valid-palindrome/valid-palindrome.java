class Solution {
	public boolean isPalindrome(String s) {
		int len = s.length();
		int start = 0, end  = len - 1;
		while(start < end){
				int lowc = s.charAt(start);
				if(!((lowc >= 48 && lowc <=57) || (lowc >= 65 && lowc <= 90) || (lowc >= 97 && lowc <= 122))){
					start++;
					continue;
				}
				int highc = s.charAt(end);
				if(!((highc >= 48 && highc <=57) || (highc >= 65 && highc <= 90) || (highc >= 97 && highc <= 122))){
					end--;
					continue;
				}
			String str = s.toLowerCase();
			if(str.charAt(start) != str.charAt(end)) return false;
			start++;
			end--;
		}
		return true;
	}
}