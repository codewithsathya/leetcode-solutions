class Solution {
    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;

        if(nums.length == 1){
            return nums[0];
        }

        while(low <= high){
            int mid = low + (high - low) / 2;
            if(mid > 0 && nums[mid] < nums[mid - 1]){
                return nums[mid];
            }
            if(nums[low] <= nums[mid] && nums[mid] > nums[high]){
                low = mid + 1;
            }else{
                high = high - 1;
            }
        }
        return nums[low];
    }
}