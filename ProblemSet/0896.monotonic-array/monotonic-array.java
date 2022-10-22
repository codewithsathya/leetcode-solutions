class Solution {
    public boolean isMonotonic(int[] nums) {
        int flag = 0;
        for(int i = 1; i < nums.length; i++){
            int diff = nums[i] - nums[i - 1];
            if(flag == 0 && diff != 0){
                flag = diff > 0 ? 1 : -1;
            }
            if(flag * diff < 0){
                return false;
            }
        }
        return true;
    }
}