class Solution {
    public String minRemoveToMakeValid(String s) {
        int len = s.length();
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < len; i++){
            if(s.charAt(i) == ')' || s.charAt(i) == '('){
                char ch = s.charAt(i);
                if(st.isEmpty()){
                    st.push(i);
                }else{
                    if(ch == ')' && s.charAt(st.peek()) == '('){
                        st.pop();
                    }else{
                        st.push(i);
                    }
                }
            }
        }
        Set<Integer> set = new HashSet<>(st);
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < len; i++){
            if(!set.contains(i)){
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}