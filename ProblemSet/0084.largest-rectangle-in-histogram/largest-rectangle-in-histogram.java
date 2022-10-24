class Solution {
    public int largestRectangleArea(int[] heights) {
        int len = heights.length;
        int[] leftSmallIndex = new int[len];
        int[] rightSmallIndex = new int[len];
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < len; i++){
            if(st.isEmpty()){
                st.push(0);
                leftSmallIndex[i] = 0;
            }else{
                int prevSmall = st.peek();
                if(heights[prevSmall] < heights[i]){
                    st.push(prevSmall + 1);
                    leftSmallIndex[i] = prevSmall + 1;
                }else{
                    while(!st.isEmpty() && heights[st.peek()] >= heights[i]){
                        st.pop();
                    }
                    if(st.isEmpty()){
                        leftSmallIndex[i] = 0;
                    }else{
                        leftSmallIndex[i] = st.peek() + 1;
                    }
                    st.push(i);
                }
            }
        }
        st.clear();
        for(int i = len - 1; i >= 0; i--){
            if(st.isEmpty()){
                st.push(len - 1);
                rightSmallIndex[i] = len - 1;
            }else{
                int nextSmall = st.peek();
                if(heights[nextSmall] < heights[i]){
                    st.push(nextSmall - 1);
                    rightSmallIndex[i] = nextSmall - 1;
                }else{
                    while(!st.isEmpty() && heights[st.peek()] >= heights[i]){
                        st.pop();
                    }
                    if(st.isEmpty()){
                        rightSmallIndex[i] = len - 1;
                    }else{
                        rightSmallIndex[i] = st.peek() - 1;
                    }
                    st.push(i);
                }
            }
        }
        int max = 0;
        for(int i = 0; i < len; ++i){
            int width = (rightSmallIndex[i] - leftSmallIndex[i]) + 1;
            max = Math.max(width * heights[i], max);
        }
        return max;
    }
}