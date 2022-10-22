class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        if(pattern.length() != words.length){
            return false;
        }
        Map<Character, String> map = new HashMap<>();
        Set<String> set = new HashSet<>();
        for(int i = 0; i < words.length; i++){
            char ch = pattern.charAt(i);
            String word = words[i];
            if(!map.containsKey(ch)){
                if(set.contains(word)){
                    return false;
                }
                map.put(ch, word);
                set.add(word);
            }else{
                if(!map.get(ch).equals(word)){
                    return false;
                }
            }
        }
        return true;
    }
}