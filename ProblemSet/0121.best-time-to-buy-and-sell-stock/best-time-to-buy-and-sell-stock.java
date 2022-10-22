class Solution {
	public int maxProfit(int[] prices) {
		int gp = 0;
		int cp;
		int buyIndex = 0;
		for(int i = 1; i < prices.length; i++){
			cp = prices[i] - prices[buyIndex];
			if(cp < 0){
				buyIndex = i;
			}else if(gp < cp){
				gp = cp;
			}
		}
		return gp;
    }
}