class Solution {
    public int lastStoneWeight(int[] stones) {
        if(stones.length == 2){
            if(stones[0] == stones[1]){
                return 0;
            }
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for(int num: stones){
            pq.add(num);
        }
        while(pq.size() > 1){
            int large = pq.poll();
            int small = pq.poll();
            int newWeight = large - small;
            if(newWeight > 0){
                pq.add(newWeight);
            }
            if(pq.isEmpty()){
                return 0;
            }
        }
        return pq.poll();
    }
}