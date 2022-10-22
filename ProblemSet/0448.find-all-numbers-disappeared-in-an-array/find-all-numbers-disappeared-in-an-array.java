class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int i = 1; i <= nums.length; i++){
            set.add(i);
        }
        for(int num: nums){
            if(set.contains(num))
                set.remove(num);
        }
        return new ArrayList<>(set);
    }
}