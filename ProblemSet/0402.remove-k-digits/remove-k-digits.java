class Solution {
    public String removeKdigits(String num, int k) {
        int len = num.length();
        int digits = len - k;
        char[] stack = new char[len];
        int top = 0;

        for(int i = 0; i < len; i++){
            char ch = num.charAt(i);
            while(top > 0 && stack[top - 1] > ch && k > 0){
                top--;
                k--;
            }
            stack[top++] = ch;
        }

        int ind = 0;
        while(ind < digits && stack[ind] == '0'){
            ind++;
        }
        return ind == digits ? "0" : new String(stack, ind, digits - ind);
    }
}