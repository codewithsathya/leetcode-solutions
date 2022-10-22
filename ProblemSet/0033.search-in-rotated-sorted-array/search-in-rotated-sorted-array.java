class Solution {
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while(low <= high){
            int mid = low + (high - low) / 2;
            int newHigh = high;
            int newLow = low;
            int newMid = mid;
            if(nums[mid] >= nums[low]){
                newHigh = mid;
                low = mid + 1;
            }else if(nums[mid] < nums[low]){
                newLow = mid;
                high = mid - 1;
            }
            while(newLow <= newHigh){
                newMid = newLow + (newHigh - newLow) / 2;
                if(nums[newMid] > target){
                    newHigh = newMid - 1;
                }else if(nums[newMid] < target){
                    newLow = newMid + 1;
                }else{
                    return newMid;
                }
            }
        }
        return -1;
    }
}