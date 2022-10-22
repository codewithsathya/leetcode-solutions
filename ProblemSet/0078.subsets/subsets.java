class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        helper(nums, 0, new ArrayList<>(), result);
        return result;
    }

    public void helper(int[] nums, int index, List<Integer> list, List<List<Integer>> result){
        if(index == nums.length){
            result.add(new ArrayList<>(list));
            return;
        }
        helper(nums, index + 1, new ArrayList<>(list), result);
        List<Integer> temp = new ArrayList<>(list);
        temp.add(nums[index]);
        helper(nums, index + 1, temp, result);
    }
}