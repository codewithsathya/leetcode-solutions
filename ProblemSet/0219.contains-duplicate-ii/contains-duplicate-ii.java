class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(i > k){
                map.remove(nums[i - k - 1]);
            }
            if(map.containsKey(nums[i])){
                return true;
            }else{
                map.put(nums[i], i);
            }
        }
        return false;
    }
}