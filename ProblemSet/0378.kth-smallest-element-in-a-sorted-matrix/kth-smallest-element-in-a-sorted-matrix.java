class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int row = matrix.length - 1;
        int col = matrix[0].length - 1;
        int low = matrix[0][0];
        int high = matrix[row][col];
        while(low < high){
            int mid = low + (high - low) / 2;
            int count = 0;
            int j = col;
            for(int i = 0; i <= row; i++){
                while(j >= 0 && matrix[i][j] > mid){
                    j--;
                }
                count += (j + 1);
            }
            if(count < k){
                low = mid + 1;
            }else{
                high = mid;
            }
        }
        return low;
    }
}