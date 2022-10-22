class Solution {
    int[] x = {0, 0, 1, -1, 1, 1, -1, -1};
    int[] y = {1, -1, 0, 0, 1, -1, 1, -1};
    public int shortestPathBinaryMatrix(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];
        Queue<Integer[]> queue = new ArrayDeque<>();
        if(grid[0][0] == 0){
            queue.add(new Integer[]{0, 0});
            visited[0][0] = true;
        }
        int count = 1;
        while(!queue.isEmpty()){
            int n = queue.size();
            for(int j = 0; j < n; j++){
                Integer[] curr = queue.poll();
                if(curr[0] == rows - 1 && curr[1] == cols - 1){
                    return count;
                }
                for(int i = 0; i < 8; i++){
                    int rr = curr[0] + y[i];
                    int cc = curr[1] + x[i];
                    if(rr < 0 || rr >= rows || cc < 0 || cc >= cols || visited[rr][cc] || grid[rr][cc] == 1){
                        continue;
                    }
                    queue.add(new Integer[]{rr, cc});
                    visited[rr][cc] = true;
                }
            }
            count++;
        }
        return -1;
    }
}