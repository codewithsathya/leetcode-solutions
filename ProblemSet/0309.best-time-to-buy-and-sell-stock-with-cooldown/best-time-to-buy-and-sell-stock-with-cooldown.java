class Solution {
    public int maxProfit(int[] prices) {
        int noStock = 0, inhand = -prices[0], sold = 0;
        for(int i = 1; i < prices.length; i++){
            int newNoStock = Math.max(noStock, sold);
            sold = inhand + prices[i];
            inhand = Math.max(inhand, noStock - prices[i]);
            noStock = newNoStock;
        }
        return Math.max(noStock, sold);
    }
}