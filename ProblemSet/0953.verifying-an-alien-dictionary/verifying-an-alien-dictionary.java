class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < 26; i++){
            map.put(order.charAt(i), i);
        }
        for(int i = 0; i < words.length - 1; i++){
            String str1 = words[i];
            String str2 = words[i + 1];
            int p1 = 0;
            while(p1 < str1.length() && p1 < str2.length() && str1.charAt(p1) == str2.charAt(p1)){
                p1++;
            }
            if(p1 >= str1.length() && p1 >= str2.length()){
                continue;
            }
            if(p1 >= str1.length()){
                return true;
            }
            if(p1 >= str2.length()){
                return false;
            }
            if(map.get(str1.charAt(p1)) > map.get(str2.charAt(p1))){
                return false;
            }
        }
        return true;
    }
}