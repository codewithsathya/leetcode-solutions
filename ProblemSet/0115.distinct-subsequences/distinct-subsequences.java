class Solution {
    Map<String, Map<String, Integer>> memo;
    public int getCount(String s, String t, int i, int j){
        String ssub = s.substring(i);
        String tsub = t.substring(j);
        if(ssub.equals(tsub)) return 1;
        if(ssub.length() < tsub.length()) return 0;
        if(memo.containsKey(ssub) && memo.get(ssub).containsKey(tsub)){
            return memo.get(ssub).get(tsub);
        }
        if(j == t.length()){
            return 1;
        }
        if(i == s.length()){
            return 0;
        }
        int count = getCount(s, t, i + 1, j);
        if(s.charAt(i) == t.charAt(j)){
            count += getCount(s, t, i + 1, j + 1);
        }
        memo.putIfAbsent(ssub, new HashMap<>());
        memo.get(ssub).put(tsub, count);
        return count;
    }

    public int numDistinct(String s, String t) {
        if(s.length() < t.length()) return 0;
        if(s.length() == t.length()) return s.equals(t) ? 1 : 0;
        memo = new HashMap<>();
        return getCount(s, t, 0, 0);
    }   
}