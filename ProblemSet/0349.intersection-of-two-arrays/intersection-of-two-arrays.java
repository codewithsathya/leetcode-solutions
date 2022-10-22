class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> first = new HashSet<>();
        Set<Integer> second = new HashSet<>();
        for(int num: nums1){
            first.add(num);
        }
        for(int num: nums2){
            if(first.contains(num)){
                second.add(num);
            }
        }
        int[] result = new int[second.size()];
        int i = 0;
        for(int num: second){
            result[i++] = num;
        }
        return result;
    }
}