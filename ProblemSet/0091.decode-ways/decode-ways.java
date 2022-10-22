class Solution {
    HashMap<Integer, Integer> memo = new HashMap<>();
    public boolean isValid(String str){
        if(str.startsWith("0")) return false;
        int value = Integer.valueOf(str);
        return (value >= 1 && value <= 26) ? true : false;
    }
    public int helper(int index, String s){
        if(memo.containsKey(index)) return memo.get(index);
        if(index == s.length()) return 1;
        int count = 0;
        String substr1 = s.substring(index, index + 1);
        if(isValid(substr1)){
            count += helper(index + 1, s);
        }
        if(index + 2 <= s.length()){
            String substr2 = s.substring(index, index + 2);
            if(isValid(substr2)){
                count += helper(index + 2, s);
            }
        }
        memo.put(index, count);
        return count;
    }
    public int numDecodings(String s) {
        return helper(0, s);
    }
}