class Solution {
    public int longestPalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for(char ch: s.toCharArray()){
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        boolean hasOdd = false;
        int sum = 0;
        for(char ch: map.keySet()){
            if(map.get(ch) % 2 == 1){
                hasOdd = true;
            }
            map.put(ch, map.get(ch) / 2);
            sum += map.get(ch);
        }
        return hasOdd ? 2 * sum + 1 : 2 * sum;
    }
}