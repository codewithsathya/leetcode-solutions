class Solution {
    public int maxProduct(int[] nums) {
        int max = nums[0];
        for(int num: nums){
            if(num > max)
                max = num;
        }
        int currMax = 1;
        int currMin = 1;
        for(int num: nums){
            // if(num == 0){
            //     currMax = currMin = 1;
            // }else{
                int temp = currMax;
                currMax = Math.max(Math.max(currMax * num, currMin * num), num);
                currMin = Math.min(Math.min(temp * num, currMin * num), num);
                max = Math.max(currMax, max);
            // }
        }
        return max;
    }
}