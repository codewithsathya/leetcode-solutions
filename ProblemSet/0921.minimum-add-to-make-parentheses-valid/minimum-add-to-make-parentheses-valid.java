class Solution {
    public int minAddToMakeValid(String s) {
        Stack<Character> st = new Stack<>();
        int count = 0;
        for(char ch: s.toCharArray()){
            if(st.isEmpty() && ch == ')'){
                count++;
            }else if(ch == '('){
                st.push('(');
            }else if(ch == ')'){
                st.pop();
            }
        }
        return count + st.size();
    }
}