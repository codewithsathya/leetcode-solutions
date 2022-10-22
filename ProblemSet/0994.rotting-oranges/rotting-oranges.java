class Solution {
    public int orangesRotting(int[][] grid) {
        int[] x = {1, -1, 0, 0};
        int[] y = {0, 0, 1, -1};
        int time = 0;
        int oldFreshCount = 0;
        int freshCount = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        Queue<Integer[]> queue = new ArrayDeque<>();
        while(true){
            for(int i = 0; i < rows; i++){
                for(int j = 0; j < cols; j++){
                    int num = grid[i][j];
                    if(num == 0){
                        continue;
                    }else if(num == 1){
                        freshCount++;
                    }else{
                        queue.add(new Integer[]{i, j});
                    }
                }
            }
            if(freshCount == 0){
                return time;
            }
            if(freshCount == oldFreshCount){
                return -1;
            }
            oldFreshCount = freshCount;
            freshCount = 0;
            time++;
            while(!queue.isEmpty()){
                Integer[] position = queue.poll();
                for(int i = 0; i < 4; i++){
                    int rr = position[0] + y[i];
                    int cc = position[1] + x[i];
                    if(rr < 0 || rr >= rows || cc < 0 || cc >= cols || grid[rr][cc] == 0){
                        continue;
                    }
                    grid[rr][cc] = 2;
                }
            }
        }
    }
}