class Solution {
	public int[] maxSlidingWindow(int[] nums, int k) {
		if(nums == null || k <= 0){
			return new int[0];
		}
		int n = nums.length;
		int[] result = new int[n - k + 1];
		Deque<Integer> queue = new ArrayDeque<>();
		int index = 0;
		for(int i = 0; i < nums.length; i++){
			while(!queue.isEmpty() && queue.peek() < i - k + 1){
				queue.poll();
			}
			while(!queue.isEmpty() && nums[queue.peekLast()] < nums[i]){
				queue.pollLast();
			}
			queue.offer(i);
			if(i >= k - 1){
				result[index++] = nums[queue.peek()];
			}
		}
		return result;
	}
}