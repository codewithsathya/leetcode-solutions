class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for(int num: time){
            count += map.getOrDefault((60 - (num % 60)), 0);
            map.put(num % 60, map.getOrDefault(num % 60, 0) + 1);
        }
        return count;
    }
}