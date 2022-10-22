class Solution {
    List<String> result = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        helper("", n, n, true, false, n);
        return result;
    }
    
    public void helper(String str, int opens, int closes, boolean canOpen, boolean canClose, int n){
        if(str.length() == 2 * n){
            this.result.add(str);
            return;
        }
        if(canOpen){
            String newStr = str + "(";
            boolean tempOpen = (opens - 1 > 0);
            boolean tempClose = (closes > opens - 1);
            helper(newStr, opens - 1, closes, tempOpen, tempClose, n);
        }
        if(canClose){
            String newStr = str + ")";
            canOpen = (opens > 0);
            canClose = (closes - 1 > opens);
            helper(newStr, opens, closes - 1, canOpen, canClose, n);
        }
    }
}