class NumMatrix {
    int[][] sum;

    public NumMatrix(int[][] matrix) {
        this.sum = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                this.sum[i][j] = 0;
                if (i > 0 && j > 0){
                    this.sum[i][j] -= this.sum[i - 1][j - 1];
                }
                if (i > 0){
                    this.sum[i][j] += this.sum[i - 1][j];
                }
                if (j > 0){
                    this.sum[i][j] += this.sum[i][j - 1];
                }
                this.sum[i][j] += matrix[i][j];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int totalSum = sum[row2][col2];
        if (row1 > 0 && col1 > 0)
            totalSum += sum[row1 - 1][col1 - 1];
        if (row1 > 0)
            totalSum -= sum[row1 - 1][col2];
        if (col1 > 0)
            totalSum -= sum[row2][col1 - 1];
        return totalSum;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */