class Solution {
    int[] memo;
    public int helper(int[] nums, int target){
        if(target == 0){
            return 1;
        }
        if(target < 0){
            return 0;
        }
        if(memo[target] != -1) return memo[target];
        int count = 0;
        for(int num: nums){
            count += helper(nums, target - num);
        }
        memo[target] = count;
        return count;
    }

    public int combinationSum4(int[] nums, int target) {
        memo = new int[target + 1];
        Arrays.fill(memo, -1);
        return helper(nums, target);
    }
}