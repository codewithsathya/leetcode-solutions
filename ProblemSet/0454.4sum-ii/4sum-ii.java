class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int[] nums12 = new int[nums1.length * nums2.length];
        int[] nums34 = new int[nums3.length * nums4.length];
        int ind = 0;
        for(int i = 0; i < nums1.length; i++){
            for(int j = 0; j < nums2.length; j++){
                nums12[ind++] = nums1[i] + nums2[j];
            }
        }
        ind = 0;
        for(int i = 0; i < nums3.length; i++){
            for(int j = 0; j < nums4.length; j++){
                nums34[ind++] = nums3[i] + nums4[j];
            }
        }
        Map<Integer, Integer> map12 = new HashMap<>();
        Map<Integer, Integer> map34 = new HashMap<>();
        for(int num: nums12){
            map12.put(num, map12.getOrDefault(num, 0) + 1);
        }
        for(int num: nums34){
            map34.put(num, map34.getOrDefault(num, 0) + 1);
        }
        int count = 0;
        for(int key: map12.keySet()){
            if(map34.containsKey(-key)){
                count += map12.get(key) * map34.get(-key);
            }
        }
        return count;
    }
}