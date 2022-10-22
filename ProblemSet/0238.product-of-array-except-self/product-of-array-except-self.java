class Solution {
    public int[] productExceptSelf(int[] nums) {
        if(nums.length == 1) return nums;
        int[] temp = new int[nums.length];
        Arrays.fill(temp, 1);
        for(int i = 1; i < temp.length; i++){
            temp[i] = temp[i - 1] * nums[i - 1];
        }
        int[] temp2 = new int[nums.length];
        Arrays.fill(temp2, 1);
        for(int i = temp.length - 2; i >= 0; i--){
            temp2[i] = temp2[i + 1] * nums[i + 1];
        }
        for(int i = 0; i < temp.length; i++){
            temp[i] *= temp2[i];
        }
        return temp;
    }
}