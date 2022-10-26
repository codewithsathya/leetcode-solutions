class Solution {
    public void helper(int n, int k, int index, List<List<Integer>> result, List<Integer> list){
        if(list.size() == k){
            result.add(new ArrayList<>(list));
        }else{
            for(int i = index; i <= n; i++){
                list.add(i);
                helper(n, k, i + 1, result, list);
                list.remove(list.size() - 1);
            }
        }
    }

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        helper(n, k, 1, result, new ArrayList<>());
        return result;
    }
}