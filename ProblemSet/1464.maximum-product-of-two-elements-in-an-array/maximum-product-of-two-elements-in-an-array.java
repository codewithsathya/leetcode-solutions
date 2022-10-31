class Solution {
    public int maxProduct(int[] nums) {
        int largest = nums[0];
        int second = 0;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] >= largest){
                second = largest;
                largest = nums[i];
            }else if(second < nums[i]){
                second = nums[i];
            }
        }
        return (largest - 1) * (second - 1);
    }
}