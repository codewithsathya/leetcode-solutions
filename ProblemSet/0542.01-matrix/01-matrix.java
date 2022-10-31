class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;
        int[][] result = new int[rows][cols];
        for(int[] row : result){
            Arrays.fill(row, -1);
        }

        for(int i = 0; i < rows; ++i){
            for(int j = 0; j < cols; ++j){
                if(mat[i][j] == 0){
                    result[i][j] = 0;
                    continue;
                }
                int top = -1;
                if(i > 0 && result[i - 1][j] != -1){
                    top = result[i - 1][j];
                }
                int left = -1;
                if(j > 0 && result[i][j - 1] != -1){
                    left = result[i][j - 1];
                }
                if(top == -1 && left == -1){
                    continue;
                }
                if(top == -1){
                    result[i][j] = 1 + left;
                }else if(left == -1){
                    result[i][j] = 1 + top;
                }else{
                    result[i][j] = 1 + Math.min(top, left);
                }
            }
        }
        for(int i = rows - 1; i >= 0; --i){
            for(int j = cols - 1; j >= 0; --j){
                if(mat[i][j] == 0){
                    continue;
                }
                int bottom = -1;
                if(i < rows - 1 && result[i + 1][j] != -1){
                    bottom = result[i + 1][j];
                }
                int right = -1;
                if(j < cols - 1 && result[i][j + 1] != -1){
                    right = result[i][j + 1];
                }

                if(bottom == -1 && right == -1){
                    continue;
                }
                if(bottom == -1){
                    if(result[i][j] == -1){
                        result[i][j] = right + 1;
                    }else{
                        result[i][j] = Math.min(result[i][j], 1 + right);
                    }
                }else if(right == -1){
                    if(result[i][j] == -1){
                        result[i][j] = bottom + 1;
                    }else{
                        result[i][j] = Math.min(result[i][j], 1 + bottom);
                    }
                }else{
                    if(result[i][j] == -1){
                        result[i][j] = 1 + Math.min(bottom, right);
                    }else{
                        result[i][j] = Math.min(result[i][j], 1 + Math.min(bottom, right));
                    }
                }
            }
        }
        return result;
    }
}