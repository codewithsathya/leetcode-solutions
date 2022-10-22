class Solution {
    public boolean containsDuplicate(int[] nums) {
      int len = nums.length;
		Set<Integer> set = new HashSet<>();
		for(int i = 0; i < len; i++){
			if(set.contains(nums[i])){
				return true;
			}
			set.add(nums[i]);
		}
		return false;
    }
}