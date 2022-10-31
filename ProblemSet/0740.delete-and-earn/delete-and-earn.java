class Solution {
    public int deleteAndEarn(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int num: nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        int prevInc = 0, prevExc = 0;
        for(int i = min; i <= max; i++){
            int incEarn = prevExc + i * map.getOrDefault(i, 0);
            int excEarn = Math.max(prevInc, prevExc);
            prevInc = incEarn;
            prevExc = excEarn;
        }
        return Math.max(prevInc, prevExc);
    }
}