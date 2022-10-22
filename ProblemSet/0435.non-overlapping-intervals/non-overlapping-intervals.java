//https://youtu.be/bC7o8P_Ste4?t=1711

class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);
        int prevStart = intervals[0][0];
        int prevEnd = intervals[0][1];
        int count = 1;
        for(int[] arr: intervals){
            if(arr[0] < prevEnd){
                continue;
            }else{
                prevStart = arr[0];
                prevEnd = arr[1];
                count++;
            }
        }
        return intervals.length - count;
    }
}