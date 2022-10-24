class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0; 
        int right = 0;
        int sum = 0;
        int len = nums.length;
        int result = 0;
        while(right < len){
            sum += nums[right];
            if(sum < target){
                right++;
            }else{
                while(left <= right && sum >= target){
                    sum -= nums[left];
                    if(result == 0)
                        result = right - left + 1;
                    result = Math.min(result, right - left + 1);
                    left++;
                }
                right++;
            }
        }
        return result;
    }
}