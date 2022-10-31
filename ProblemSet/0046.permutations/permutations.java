class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, 0, nums.length - 1, result);
        return result;
    }

    public void backtrack(int[] nums, int l, int r, List<List<Integer>> result){
        if(l == nums.length){
            List<Integer> list = new ArrayList<>();
            for(int num: nums){
                list.add(num);
            }
            result.add(list);
            return;
        }
        for(int i = l; i <= r; i++){
            swap(nums, i, l);
            backtrack(nums, l + 1, r, result);
            swap(nums, i, l);
        }
    }

    public void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}