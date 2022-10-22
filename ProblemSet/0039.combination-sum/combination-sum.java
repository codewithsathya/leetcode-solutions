class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Stack<Integer> st = new Stack<>();
        helper(0, target, candidates, st, list);
        return list;
    }

    public void helper(int index, int target, int[] candidates, Stack<Integer> st, List<List<Integer>> result){
        if(target < 0){
            return;
        }
        if(index >= candidates.length){
            if(target == 0){
                List<Integer> list = new ArrayList<>(st);
                result.add(list);
                return;
            }
            return;
        }
        st.push(candidates[index]);
        helper(index, target - candidates[index], candidates, st, result);
        st.pop();
        helper(index + 1, target, candidates, st, result);
    }
}