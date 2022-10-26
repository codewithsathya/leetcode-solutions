class Solution {
    public int splitArray(int[] nums, int k) {
        int low = 0;
        int high = 0;
        for(int num: nums){
            low = Math.max(low, num);
            high += num;
        }
        while(low <= high){
            int mid = low + (high - low) / 2;
            int count = 0;
            int sum = 0;
            for(int i = 0; i < nums.length; ++i){
                sum += nums[i];
                if(sum > mid){
                    sum = nums[i];
                    count++;
                }
            }
            count++;
            if(count <= k){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return low;
    }
}