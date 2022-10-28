class Solution {
    public int maxProfit(int k, int[] prices) {
        int len = prices.length;
        int[] buy = new int[k];
        Arrays.fill(buy, Integer.MIN_VALUE);
        int[] sell = new int[k];
        for(int i = 0; i < len; i++){
            for(int j = 0; j < k; j++){
                buy[j] = Math.max(buy[j], j == 0 ? -prices[i] : sell[j - 1] - prices[i]);
                sell[j] = Math.max(sell[j], buy[j] + prices[i]);
            }
        }
        return sell[k - 1];
    }
}