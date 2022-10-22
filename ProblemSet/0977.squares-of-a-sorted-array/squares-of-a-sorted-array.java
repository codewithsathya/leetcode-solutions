class Solution {
    public int[] sortedSquares(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        int writer = nums.length - 1;
        int[] result = new int[nums.length];

        while(low <= high){
            if(sq(nums[high]) >= sq(nums[low])){
                result[writer--] = sq(nums[high--]);
            }else{
                result[writer--] = sq(nums[low++]);
            }
        }
        return result;
    }

    private int sq(int n){
        return n * n;
    }
}