class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> hset = new HashSet<>();
        for(int num: nums){
            hset.add(num);
        }
        int maxCount = 0;
        for(int num: hset){
            if(hset.contains(num - 1)) continue;
            int temp = num;
            while(hset.contains(temp + 1)){
                temp++;
            }
            maxCount = Math.max(maxCount, temp - num + 1);
        }
        return maxCount;
    }
}