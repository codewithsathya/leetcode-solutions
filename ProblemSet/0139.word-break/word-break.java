class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] arr = new boolean[s.length() + 1];
        arr[0] = true;
        for(int i = 0; i < arr.length; i++){
            if(arr[i]){
                for(String str: wordDict){
                    int len = str.length();
                    int lastIndex = i + len;
                    if(lastIndex < arr.length && s.substring(i, lastIndex).equals(str)){
                            arr[lastIndex] = true;
                        }
                    }
                }
            }
        return arr[s.length()];
    }
}