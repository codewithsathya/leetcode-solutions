class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        Stack<Integer[]> st = new Stack<>();
        st.push(new Integer[]{intervals[0][0], intervals[0][1]});
        for(int i = 1; i < intervals.length; i++){
            Integer[] interval = st.peek();
            int prevEnd = interval[1];
            int newStart = intervals[i][0];
            if(newStart <= prevEnd){
                st.pop();
                st.push(new Integer[]{interval[0], Math.max(interval[1], intervals[i][1])});
            }else{
                st.push(new Integer[]{intervals[i][0], intervals[i][1]});
            }
        }
        int[][] result = new int[st.size()][];
        int i = 0;
        while(!st.isEmpty()){
            Integer[] interval = st.pop();
            result[i++] = new int[]{interval[0], interval[1]};
        }
        return result;
    }
}