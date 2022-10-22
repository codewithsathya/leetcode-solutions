class Solution {
    public void rotate(int[] nums, int k) {
        int[] temp = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            int prevIndex = (i + nums.length - k);
            while(prevIndex < 0){
                prevIndex += nums.length;
            }
            temp[i] = nums[prevIndex % nums.length];
        }
        for(int i = 0; i < nums.length; i++){
            nums[i] = temp[i];
        }
    }
}