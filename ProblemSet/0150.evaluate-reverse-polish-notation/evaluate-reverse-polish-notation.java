class Solution {
	public int evalRPN(String[] tokens) {
		Stack<Integer> st = new Stack<>();
		for(String token: tokens){
			if(token.equals("*") || token.equals("/") || token.equals("+") || token.equals("-")){
				int second = st.pop();
				int first = st.pop();
				int result = 0;
				switch(token){
					case "*":
						result = first * second;
						break;
					case "/":
						result = first / second;
						break;
					case "+":
						result = first + second;
						break;
					case "-":
						result = first - second;
						break;
				}
				st.push(result);
			}else{
				st.push(Integer.valueOf(token));
			}
		}
		return st.pop();
	}
}