class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        LinkedList<List<Integer>> result = new LinkedList<>();
        if(nums.length < 3) return result;
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 2; ++i){
            if(i == 0 || nums[i] != nums[i - 1]){
                int reqNum = -nums[i];
                int low = i + 1;
                int high = nums.length - 1;
                while(low < high){
                    if(nums[low] + nums[high] == reqNum){
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[low]);
                        list.add(nums[high]);
                        result.add(list);
                        while(low < high && nums[low] == nums[low + 1])
                            low++;
                        while(low < high && nums[low] == nums[high - 1])
                            high--;
                        low++;
                        high--;
                    }else if(nums[low] + nums[high] < reqNum){
                        low++;
                    }else{
                        high--;
                    }
                }
            }
        }
        return result;
    }
}