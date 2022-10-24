class Solution {
    public int countCharacters(String[] words, String chars) {
        Map<Character, Integer> map = new HashMap<>();
        for(char ch: chars.toCharArray()){
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        int sum = 0;
        for(String word: words){
            Map<Character, Integer> temp = new HashMap<>();
            for(char ch: word.toCharArray()){
                temp.put(ch, temp.getOrDefault(ch, 0) + 1);
            }
            boolean valid = true;
            for(char ch: word.toCharArray()){
                if(map.get(ch) == null || temp.get(ch) > map.get(ch)){
                    valid = false;
                    break;
                }
            }
            if(valid){
                sum += word.length();
            }
        }
        return sum;
    }
}