class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> beginSet = new HashSet<>();
        Set<String> endSet = new HashSet<>();
        Set<String> visited = new HashSet<>();
        Set<String> dict = new HashSet<>(wordList);
        beginSet.add(beginWord);
        if(dict.contains(endWord)){
            endSet.add(endWord);
        }

        int length = 1;

        while(!beginSet.isEmpty() && !endSet.isEmpty()){
            Set<String> nextBeginSet = new HashSet<>();
            for(String word : beginSet){
                char[] chars = word.toCharArray();
                for(int i = 0; i < chars.length; i++){
                    for(char j = 'a'; j <= 'z'; j++){
                        char old = chars[i];
                        chars[i] = j;
                        String newWord = new String(chars);
                        if(newWord.equals(endWord)){
                            return length + 1;
                        }
                        if(!visited.contains(newWord) && dict.contains(newWord)){
                            visited.add(newWord);
                            nextBeginSet.add(newWord);
                        }
                        chars[i] = old;
                    }
                }
            }
            beginSet = nextBeginSet;
            length++;
        }
        return 0;
    }

}