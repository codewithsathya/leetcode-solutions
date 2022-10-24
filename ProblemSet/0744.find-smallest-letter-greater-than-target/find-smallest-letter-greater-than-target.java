class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        char res = 'z' + 1;
        for(char ch: letters){
            if(ch > target){
                res = (char)Math.min(res, ch);
            }
        }
        return res == 'z' + 1 ? letters[0] : res;
    }
}