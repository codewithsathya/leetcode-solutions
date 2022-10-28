class Solution {
    boolean isPalindrome(String s, int start, int end){
        while(start < end){
            if(s.charAt(start++) != s.charAt(end--)){
                return false;
            }
        }
        return true;
    }

    void helper(String s, int start, List<String> curr, List<List<String>> result){
        int len = s.length();
        if(start >= len){
            result.add(new ArrayList<>(curr));
        }else{
            for(int end = start; end < len; ++end){
                if(isPalindrome(s, start, end)){
                    curr.add(s.substring(start, end + 1));
                    helper(s, end + 1, curr, result);
                    curr.remove(curr.size() - 1);
                }
            }
        }
    }

    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        helper(s, 0, new ArrayList<>(), result);
        return result;
    }
}