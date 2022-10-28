class Solution {
    public int findLargestAreaInHistogram(int[] height){
        int len = height.length;
        Stack<Integer> stack = new Stack<>();
        int[] prevLargest = new int[len];
        int[] nextLargest = new int[len];
        for(int i = 0; i < len; i++){
            if(stack.isEmpty()){
                prevLargest[i] = 0;
                stack.push(0);
            }else{
                int peek = stack.peek();
                if(height[peek] >= height[i]){
                    while(!stack.isEmpty() && height[stack.peek()] >= height[i]){
                        stack.pop();
                    }
                    if(stack.isEmpty()){
                        prevLargest[i] = 0;
                    }else{
                        prevLargest[i] = stack.peek() + 1;
                    }
                }else{
                    prevLargest[i] = peek + 1;
                }
                stack.push(i);
            }
        }
        stack.clear();
        for(int i = len - 1; i >= 0; --i){
            if(stack.isEmpty()){
                nextLargest[i] = len - 1;
                stack.push(len - 1);
            }else{
                int peek = stack.peek();
                if(height[peek] >= height[i]){
                    while(!stack.isEmpty() && height[stack.peek()] >= height[i]){
                        stack.pop();
                    }
                    if(stack.isEmpty()){
                        nextLargest[i] = len - 1;
                    }else{
                        nextLargest[i] = stack.peek() - 1;
                    }
                }else{
                    nextLargest[i] = peek - 1;
                }
                stack.push(i);
            }
        }
        int max = 0;
        for(int i = 0; i < len; i++){
            max = Math.max(max, height[i] * (nextLargest[i] - prevLargest[i] + 1));
        }
        return max;
    }

    public int maximalRectangle(char[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[] height = new int[cols];
        int max = 0;
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(matrix[i][j] == '1'){
                    height[j]++;
                }else{
                    height[j] = 0;
                }
            }
            System.out.println(Arrays.toString(height));
            max = Math.max(max, findLargestAreaInHistogram(height));
        }
        return max;
    }
}