public class Solution {
    public int[] searchRange(int[] nums, int target) {
        if(nums.length == 0) return new int[]{-1, -1};
        int low = 0;
        int high = nums.length - 1;
        while(low <= high){
            int mid = low + (high - low) / 2;
            if(target <= nums[mid]){
                high = mid - 1;
            }else if(target > nums[mid]){
                low = mid + 1;
            }
        }
        if(low >= nums.length || target != nums[low]){
            return new int[]{-1, -1};
        }
        int[] result = new int[2];
        result[0] = low;
        low = 0;
        high = nums.length - 1;
        while(low <= high){
            int mid = low + (high - low) / 2;
            if(target < nums[mid]){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        result[1] = high;
        return result;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] arr = {2, 2};
        int target = 3;
        int[] res = sol.searchRange(arr, target);
        System.out.println(Arrays.toString(res));
    }
}