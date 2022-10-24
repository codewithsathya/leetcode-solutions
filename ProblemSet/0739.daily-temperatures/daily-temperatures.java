class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int len = temperatures.length;
        int[] result = new int[len];
        for(int i = len - 1; i >= 0; i--){
            if(stack.isEmpty()){
                stack.add(len - 1);
                result[i] = 0;
            }else{
                int nextLarge = stack.peek();
                if(temperatures[nextLarge] > temperatures[i]){
                    stack.push(nextLarge - 1);
                    result[i] = nextLarge - i;
                }else{
                    while(!stack.isEmpty() && temperatures[stack.peek()] <= temperatures[i]){
                        stack.pop();
                    }
                    if(stack.isEmpty()){
                        result[i] = 0;
                    }else{
                        result[i] = stack.peek() - i;
                    }
                    stack.push(i);
                }
            }
        }
        return result;
    }
}