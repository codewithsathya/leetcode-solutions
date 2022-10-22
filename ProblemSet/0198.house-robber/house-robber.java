class Solution {
    public int rob(int[] nums) {
        int prevDid = 0;
        int prevDidnt = 0;
        for(int curr: nums){
            int currDid = prevDidnt + curr;
            int currDidnt = prevDid > prevDidnt ? prevDid : prevDidnt;
            prevDid = currDid;
            prevDidnt = currDidnt;
        }
        return prevDid > prevDidnt ? prevDid : prevDidnt;
    }
}