class Solution {
	public int characterReplacement(String s, int k) {
		int len = s.length();
		if(len == 1) return 1;
		int left = 0;
		int right = 0;
		HashMap<Character, Integer> hmap = new HashMap<>();
		int maxLen = 0;
		while(right < len){
			char currChar = s.charAt(right);
			if(hmap.containsKey(currChar)){
				hmap.put(currChar, hmap.get(currChar) + 1);
			}else{
				hmap.put(currChar, 1);
			}
			int maxFreq = 0;
			for(char ch: hmap.keySet()){
				maxFreq = Math.max(maxFreq, hmap.get(ch));
			}
			if((right - left + 1) - maxFreq <= k){
				maxLen = Math.max(maxLen, right - left + 1);
				right++;
			}else{
				hmap.put(s.charAt(left), hmap.get(s.charAt(left)) - 1);
				hmap.put(currChar, hmap.get(currChar) - 1);
				left++;
			}
		}
		return maxLen;
	}
}