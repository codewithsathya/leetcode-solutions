class Solution {
	public boolean isAnagram(String s, String t) {
		HashMap<Character, Integer> hmaps = new HashMap<>();
		for(char c: s.toCharArray()){
			if(!hmaps.containsKey(c))
				hmaps.put(c, 1);
			else
				hmaps.put(c, hmaps.get(c) + 1);
		}
		for(char c: t.toCharArray()){
			if(!hmaps.containsKey(c) || hmaps.get(c) == 0)
				return false;
			else{
				hmaps.put(c, hmaps.get(c) - 1);
			}
		}
		for(char c : hmaps.keySet()){
			if(hmaps.get(c) != 0) return false;
		}
		return true;
	}
}