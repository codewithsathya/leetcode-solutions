class Solution {
    int dist(int x, int y){
        return x * x + y * y;
    }

    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Integer[]> pq = new PriorityQueue<>((a, b) -> dist(a[0], a[1]) - dist(b[0], b[1]));
        for(int[] point: points){
            pq.add(new Integer[]{point[0], point[1]});
        }
        int[][] result = new int[k][2];
        for(int i = 0; i < k; i++){
            Integer[] node = pq.poll();
            result[i] = new int[]{node[0], node[1]};
        }
        return result;
    }
}