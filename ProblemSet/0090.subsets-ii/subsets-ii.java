class Solution {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        int len = nums.length;
        Arrays.sort(nums);
        Set<String> set = new HashSet<>();
        List<List<Integer>> result = new ArrayList<>();
        for(int i = 0; i < 1 << len; i++){
            List<Integer> list = new ArrayList<>();
            int mask = 1;
            int count = 0;
            while(mask < (1 << len)){
                if((mask & i) > 0){
                    list.add(nums[count]);
                }
                count++;
                mask <<= 1;
            }
            if(!set.contains(list.toString())){
                result.add(list);
                set.add(list.toString());
            }
        }
        return result;
    }
}