class Solution {
    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        if (len == 0 || len == 1)
            return len;
        int low = 0;
        HashMap<Character, Integer> hmap = new HashMap<>();
        hmap.put(s.charAt(low), 0);
        int max = 1;
        for (int i = 1; i < len; ++i) {
            char ch = s.charAt(i);
            if (hmap.containsKey(ch)) {
                max = Math.max(max, i - low);
                int dupPos = hmap.get(ch);
                while (low <= dupPos) {
                    char temp = s.charAt(low);
                    hmap.remove(temp);
                    low++;
                }
            }
            hmap.put(ch, i);
        }
        max = Math.max(max, s.length() - low);
        return max;
    }
}