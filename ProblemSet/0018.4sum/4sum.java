class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 3; i++){
            if (i > 0 && nums[i - 1] == nums[i]) {
                continue;
            }
            for(int j = i + 1; j < nums.length - 2; j++){
                if (j > i + 1 && nums[j - 1] == nums[j]) {
                    continue;
                }
                int left = j + 1;
                int right = nums.length - 1;
                while(left < right){
                    long sum = (long)nums[i] + (long)nums[j] + (long)nums[left] + (long)nums[right];
                    if(sum == target){
                        result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        while(left + 1 < right && nums[left] == nums[left + 1]){
                            left++;
                        }
                        while(right - 1 > left && nums[right] == nums[right - 1]){
                            right--;
                        }
                        left++;
                        right--;
                    }else if(sum < target){
                        left++;
                    }else{
                        right--;
                    }
                }
            }
        }
        return result;
    }
}