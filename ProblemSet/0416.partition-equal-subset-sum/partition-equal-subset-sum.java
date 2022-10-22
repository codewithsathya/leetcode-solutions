class Solution {
    HashMap<Integer, HashMap<Integer, Boolean>> memo = new HashMap<>();
    public boolean canPartition(int index, int currentSum, int totalSum, int[] nums){
        if(memo.containsKey(index) && memo.get(index).containsKey(currentSum)){
            return memo.get(index).get(currentSum);
        }
        if(index >= nums.length) return false;
        if(totalSum - currentSum == currentSum) return true;
        if(totalSum - currentSum < currentSum) return false;
        int addedSum = currentSum + nums[index];
        boolean res = canPartition(index + 1, addedSum, totalSum, nums) || canPartition(index + 1, currentSum, totalSum, nums);
        if(memo.containsKey(index)){
            memo.get(index).put(currentSum, res);
        }else{
            HashMap<Integer, Boolean> hmap = new HashMap<>();
            hmap.put(currentSum, res);
            memo.put(index, hmap);
        }
        return res;
    }

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int x: nums){
            sum += x;
        }
        return canPartition(0, 0, sum, nums);
    }
}