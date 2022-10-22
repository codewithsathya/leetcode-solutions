class Solution {
    public void sortColors(int[] nums) {
        int zero = 0;
        int two = nums.length - 1;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0){
                while(nums[zero] == 0 && zero < i){
                    zero++;
                }
                int temp = nums[zero];
                nums[zero] = nums[i];
                nums[i] = temp;
            }else if(nums[i] == 2){
                while(nums[two] == 2 && two > i){
                    two--;
                }
                int temp = nums[two];
                nums[two] = nums[i];
                nums[i] = temp;
                if(temp == 0){
                    i--;
                }
            }
        }
    }
}