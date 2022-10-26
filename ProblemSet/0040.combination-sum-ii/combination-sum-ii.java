class Solution {
    void backtrack(int[] candidates, int index, List<List<Integer>> result, int target, List<Integer> current){
        if(target == 0){
            result.add(new ArrayList<>(current));
        }else if(target > 0){
            for(int i = index; i < candidates.length; i++){
                if(candidates[i] > target || (i > index && candidates[i - 1] == candidates[i]))
                    continue;
                current.add(candidates[i]);
                backtrack(candidates, i + 1, result, target - candidates[i], current);
                current.remove(current.size() - 1);
            }
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        backtrack(candidates, 0, result, target, new ArrayList<>());
        return result;
    }
}