class Solution {
	public int search(int[] nums, int target) {
		return search(nums, 0, nums.length - 1, target);
	}

	public int search(int[] nums, int low, int high, int target){
		int mid = (low + high) / 2;
		if(nums[mid] == target){
			return mid;
		}
		if(low == high) return -1;
		if(nums[mid] < target){
			return search(nums, mid + 1, high, target);
		}else{
			return search(nums, low, mid, target);
		}
	}
}