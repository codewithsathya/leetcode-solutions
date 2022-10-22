class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        if(nums.length == 0){
			return target == 0 ? 1 : 0;
		}
			int add = target + nums[0];
			int sub = target - nums[0];
			int[] newArr = new int[nums.length - 1];
			for(int i = 0; i < nums.length - 1; i++){
				newArr[i] = nums[i + 1];
			}
			return findTargetSumWays(newArr, add) + findTargetSumWays(newArr, sub);
    }
}