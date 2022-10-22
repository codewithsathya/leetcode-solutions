class Solution {
    int count = 0;

    boolean isAnagram(Map<Character, Integer> s1, Map<Character, Integer> s2){
        if(s1.size() != s2.size()){
            return false;
        }
        for(char ch: s1.keySet()){
            int len1 = s1.get(ch);
            if(!s2.containsKey(ch))
                return false;
            int len2 = s2.get(ch);
            if(len1 != len2){
                return false;
            }
        }
        return true;
    }

    public List<Integer> findAnagrams(String s, String p) {
        int wl = p.length();
        int len = s.length();
        if(wl > len){
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();
        Map<Character, Integer> sMap = new HashMap<>();
        Map<Character, Integer> pMap = new HashMap<>();
        for(char ch: p.toCharArray()){
            pMap.put(ch,  pMap.getOrDefault(ch, 0) + 1);
        }
        for(int i = 0; i < wl; i++){
            char ch = s.charAt(i);
            sMap.put(ch, sMap.getOrDefault(ch, 0) + 1);
        }
        if(isAnagram(sMap, pMap)){
            result.add(0);
        }
        for(int i = 1; i < len + 1 - wl; i++){
            char prev = s.charAt(i - 1);
            if(sMap.get(prev) == 1){
                sMap.remove(prev);
            }else{
                sMap.put(prev, sMap.get(prev) - 1);
            }
            char end = s.charAt(i + wl - 1);
            sMap.put(end, sMap.getOrDefault(end, 0) + 1);
            if(isAnagram(sMap, pMap)){
                result.add(i);
            }
        }
        return result;
    }
}