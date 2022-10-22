class Solution {
    public List<List<Integer>> permute(int[] nums) {
        Set<Integer> visited = new HashSet<>();
        Stack<Integer> stack = new Stack<>();
        List<List<Integer>> permutations = new ArrayList<>();
        backtrack(0, visited, nums, stack, permutations);
        return permutations;
    }

    public void backtrack(int index, Set<Integer> visited, int[] nums, Stack<Integer> stack, List<List<Integer>> permutations){
        if(index >= nums.length){
            permutations.add(new ArrayList<>(stack));
            return;
        }
        for(int i = 0; i < nums.length; i++){
            if(visited.contains(nums[i])) continue;
            stack.push(nums[i]);
            visited.add(nums[i]);
            backtrack(index + 1, visited, nums, stack, permutations);
            stack.pop();
            visited.remove(nums[i]);
        }
    }
}