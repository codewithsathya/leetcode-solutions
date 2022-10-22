class Solution {
    public void moveZeroes(int[] nums) {
        int w = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != 0){
                nums[w++] = nums[i];
            }
        }
        for(;w < nums.length; w++){
            nums[w] = 0;
        }
    }
}