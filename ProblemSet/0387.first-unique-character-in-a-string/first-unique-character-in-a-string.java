class Solution {
    public int firstUniqChar(String s) {
        Set<Character> duplicates = new HashSet<>();
        Set<Character> visited = new HashSet<>();
        for(char ch: s.toCharArray()){
            if(duplicates.contains(ch)){
                continue;
            }
            if(visited.contains(ch)){
                visited.remove(ch);
                duplicates.add(ch);
            }else{
                visited.add(ch);
            }
        }
        for(int i = 0; i < s.length(); i++){
            if(visited.contains(s.charAt(i))){
                return i;
            }
        }
        return -1;
    }
}