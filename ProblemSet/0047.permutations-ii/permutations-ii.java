class Solution {
    public void backtrack(int[] nums, boolean[] used, List<Integer> curr, List<List<Integer>> result){
        if(curr.size() == nums.length){
            result.add(new ArrayList<>(curr));
        }
        for(int i = 0; i < nums.length; i++){
            if(used[i]) continue;
            if(i > 0 && nums[i] == nums[i - 1] && used[i - 1]) continue;

            curr.add(nums[i]);
            used[i] = true;
            backtrack(nums, used, curr, result);
            curr.remove(curr.size() - 1);
            used[i] = false;
        }
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        backtrack(nums, used, new ArrayList<>(), result);
        return result;
    }

}