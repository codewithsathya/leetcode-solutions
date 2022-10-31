class Solution {
    public int findMaxLength(int[] nums) {
        int len = nums.length;
        int max = 0;
        int sum = 0;
        for(int i = 0; i < len; i++){
            if(nums[i] == 0){
                nums[i] = -1;
            }
        }
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < len; i++){
            sum += nums[i];
            if(!map.containsKey(sum)){
                map.put(sum, i);
            }
            if(sum == 0){
                max = Math.max(max, i + 1);
            }else{
                max = Math.max(max, i - map.get(sum));
            }
        }
        return max;
    }
}