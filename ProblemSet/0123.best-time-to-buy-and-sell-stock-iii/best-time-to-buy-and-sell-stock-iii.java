class Solution {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if(len == 1) return 0;
        int[] left = new int[len];
        int[] right = new int[len];
        left[0] = 0;
        right[len - 1] = 0;
        int min = prices[0];
        for(int i = 1; i < len; i++){
            min = Math.min(min, prices[i]);
            left[i] = Math.max(left[i - 1], prices[i] - min);
        }

        int max = prices[len - 1];
        for(int i = len - 2; i >= 0; i--){
            max = Math.max(max, prices[i]);
            right[i] = Math.max(right[i + 1], max - prices[i]);
        }
        int result = 0;
        for(int i = 0; i < len; i++){
            result = Math.max(result, left[i] + right[i]);
        }
        return result;
    }
}