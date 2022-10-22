class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int[] result = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            int nextGreater = -1;
            boolean solved = false;
            for(int j = i + 1; j < nums.length; j++){
                if(nums[j] > nums[i]){
                    nextGreater = nums[j];
                    solved = true;
                    break;
                }
            }
            if(!solved){
                for(int j = 0; j < i; j++){
                    if(nums[j] > nums[i]){
                        nextGreater = nums[j];
                        solved = true;
                        break;
                    }
                }
            }
            result[i] = nextGreater;
        }
        return result;
    }
}