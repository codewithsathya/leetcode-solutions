class Solution {
    public String getHint(String secret, String guess) {
        int bulls = 0;
        int cows = 0;
        Map<Character, Integer> secretMap = new HashMap<>();
        int sLen = secret.length();
        int gLen = guess.length();
        for(int i = 0; i < sLen; i++){
            char ch = secret.charAt(i);
            if(ch == guess.charAt(i)){
                bulls++;
            }else{
                secretMap.put(ch, secretMap.getOrDefault(ch, 0) + 1);
            }
        }
        for(int i = 0; i < gLen; i++){
            char gCh = guess.charAt(i);
            if(gCh != secret.charAt(i)){
                if(secretMap.containsKey(gCh) && secretMap.get(gCh) > 0){
                    cows++;
                    secretMap.put(gCh, secretMap.get(gCh) - 1);
                }
            }
        }
        String result = bulls + "A" + cows + "B";
        return result;
    }
}