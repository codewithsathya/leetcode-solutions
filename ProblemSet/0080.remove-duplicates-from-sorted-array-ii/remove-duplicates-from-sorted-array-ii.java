class Solution {
    public int removeDuplicates(int[] nums) {
        int w = 0;
        int r = 0;
        while(r < nums.length){
            if(w - 2 >= 0){
                if(nums[r] == nums[w - 2]){
                    while(r < nums.length && nums[r] == nums[w - 2]){
                        r++;
                    }
                }
                if(r >= nums.length) break;
                nums[w] = nums[r];
            }
            w++;
            r++;
        }
        return nums.length - r + w;
    }
}