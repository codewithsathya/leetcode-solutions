class Solution {
    public boolean canJump(int[] nums) {
        if(nums.length == 1) return true;
        int neededJumps = 1;
        for(int i = nums.length - 2; i > 0; i--){
            if(nums[i] < neededJumps){
                neededJumps++;
            }else{
                neededJumps = 1;
            }
        }
        return !(nums[0] < neededJumps);
    }
}