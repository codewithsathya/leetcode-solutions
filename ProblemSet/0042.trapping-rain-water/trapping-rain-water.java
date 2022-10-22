class Solution {
	public int trap(int[] height) {
			int[] maxLeft = new int[height.length];
			int[] maxRight = new int[height.length];
			int[] minLR = new int[height.length];
			int max = 0;
			for(int i = 0; i < height.length - 1; i++){
				if(height[i] > max){
					max = height[i];
				}
				maxLeft[i + 1] = max;
			}
			max = 0;
			for(int i = height.length - 1; i >= 1; --i){
				if(height[i] > max){
					max = height[i];
				}
				maxRight[i - 1] = max;
			}
			for(int i = 0; i < height.length; i++){
				int min = Math.min(maxLeft[i], maxRight[i]);
				int waterHeight = min - height[i];
				minLR[i] = waterHeight < 0 ? 0 : waterHeight;
			}
			int sum = 0;
			for(int water: minLR){
				sum += water;
			}
			return sum;
	}
}