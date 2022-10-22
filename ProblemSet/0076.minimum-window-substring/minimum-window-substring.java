class CharMap{
	char ch;
	int index;
	CharMap(char ch, int index){
		this.ch = ch;
		this.index = index;
	}
}

class Solution {
	public String minWindow(String s, String t) {
		int slen = s.length();
		int tlen = t.length();
		if(tlen > slen) return "";
		ArrayList<CharMap> list = new ArrayList<>();
		HashMap<Character, Integer> needed = new HashMap<>();
		HashMap<Character, Integer> have = new HashMap<>();
		for(char ch: t.toCharArray()){
			int count = needed.getOrDefault(ch, 0);
			needed.put(ch, count + 1);
			have.put(ch, 0);
		}
		for(int i = 0; i < slen; i++){
			if(needed.containsKey(s.charAt(i))){
				list.add(new CharMap(s.charAt(i), i));
			}
		}
		int left = 0;
		int right = 0;
		int count = 0;
		int start = 0;
		int end = -1;
		while(right < list.size()){
			char rightCh = s.charAt(list.get(right).index);
			have.put(rightCh, have.get(rightCh) + 1);
			if(have.get(rightCh) <= needed.get(rightCh)){
				count++;
			}
			while(count == tlen){
				if(end == -1 || end -  start + 1 > list.get(right).index - list.get(left).index + 1){
					start = list.get(left).index;
					end = list.get(right).index;
				}
				char leftCh = s.charAt(list.get(left).index);
				int tempCount = have.get(leftCh);
				have.put(leftCh, tempCount - 1);
				if(have.get(leftCh) < needed.get(leftCh)){
					count--;
				}
				left++;

			}
			right++;
		}
		return s.substring(start, end + 1);
	}
}