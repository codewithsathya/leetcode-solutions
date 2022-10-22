class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];
        int prevDid = 0;
        int prevDidnt = 0;
        for(int i = 1; i < nums.length; i++){
            int currDid = prevDidnt + nums[i];
            int currDidnt = Math.max(prevDid, prevDidnt);
            prevDid = currDid;
            prevDidnt = currDidnt;
        }
        int sol1 = Math.max(prevDid, prevDidnt);
        prevDid = 0;
        prevDidnt = 0;
        for(int i = 0; i < nums.length - 1; i++){
            int currDid = prevDidnt + nums[i];
            int currDidnt = Math.max(prevDid, prevDidnt);
            prevDid = currDid;
            prevDidnt = currDidnt;
        }
        return Math.max(Math.max(prevDid, prevDidnt), sol1);
    }
}