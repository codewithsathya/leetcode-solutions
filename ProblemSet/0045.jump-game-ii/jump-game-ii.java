class Solution {
    Map<Integer, Integer> memo;
    public int helper(int index, int[] nums){
        if(memo.containsKey(index)){
            return memo.get(index);
        }
        if(index == nums.length - 1){
            return 0;
        }
        int jumps = nums[index];
        if(jumps == 0){
            return 10000000;
        }
        int min = 10000000;
        for(int i = jumps; i > 0; i--){
            if(index + i >= nums.length){
                continue;
            }
            int no = helper(index + i, nums);

            min = Math.min(no, min);
        }
        memo.put(index, min + 1);
        return min + 1;
    }

    public int jump(int[] nums) {
        memo = new HashMap<>();
        return (int)helper(0, nums);
    }
}