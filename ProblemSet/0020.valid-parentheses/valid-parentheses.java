class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char[] open = {'(', '[', '{'};
        char[] close = {')', ']', '}'};
        Map<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');
        Set<Character> opens = new HashSet<>();
        Set<Character> closes = new HashSet<>();
        for(int i = 0; i < 3; i++){
            opens.add(open[i]);
            closes.add(close[i]);
        }
        for(char ch: s.toCharArray()){
            if(opens.contains(ch)){
                stack.push(ch);
            }else if(closes.contains(ch)){
                if(stack.isEmpty()){
                    return false;
                }
                char peek = stack.peek();
                if(map.get(peek) == ch){
                    stack.pop();
                }else{
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}