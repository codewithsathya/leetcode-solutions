class Solution {
	public boolean searchMatrix(int[][] matrix, int target) {
		int low = 0;
		int row;
		int high = matrix.length - 1;
		while(true){
			int mid = (low + high) / 2;
            
			if(high < 0){
				return false;
			}
			if(low == high && target < matrix[mid][0]){
				row = mid - 1;
                if(row < 0){
                    return false;
                }
				break;
			}
			if(low >= high && target > matrix[mid][0]){
				row = mid;
				break;
			}
            if(matrix[mid][0] < target){
				low = mid + 1;
			}else if(matrix[mid][0] > target){
				high = mid - 1;
			}else{
				return true;
			}
		}
		low = 0;
		high = matrix[row].length - 1;
		while(low <= high){
			int mid = (low + high) / 2;
			if(target > matrix[row][mid]){
				low = mid + 1;
			}else if(target < matrix[row][mid]){
				high = mid - 1;
			}else{
				return true;
			}
		}
		return false;
	}
}