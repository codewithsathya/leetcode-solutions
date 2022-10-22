class Solution {
    int[] prefixSum;
    public Solution(int[] w) {
        prefixSum = new int[w.length];
        prefixSum[0] = w[0];
        for(int i = 1; i < w.length; i++){
            prefixSum[i] = w[i] + prefixSum[i - 1];
        }
    }
    
    public int pickIndex() {
        int sum = prefixSum[prefixSum.length - 1];
        int r = (int)(Math.random() * sum);
        int low = 0;  
        int high = prefixSum.length - 1;
        while(low < high){
            int mid = low + (high - low) / 2;
            if(prefixSum[mid] <= r){
                low = mid + 1;
            }else{
                high = mid;
                if(high - 1 > 0 && prefixSum[high - 1] < r){
                    return high;
                }
            }
        }
        return high;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */