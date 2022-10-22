class Solution {
    public int lengthOfLIS(int[] nums) {
        if(nums.length == 1) return 1;
        int[] table = new int[nums.length];
        table[0] = 1;
        for(int i = 1; i < nums.length; i++){
            int max = 0;
            for(int j = 0; j < i; j++){
                if(nums[j] < nums[i] && table[j] > max){
                    max = table[j];
                }
            }
            table[i] = 1 + max;
        }
        int res = 0;
        for(int len: table){
            if(len > res)
                res = len;
        }
        return res;
    }
}