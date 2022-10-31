class Solution {
    Map<Integer, Integer> memo;
    public int helper(int n){
        if(memo.containsKey(n)){
            return memo.get(n);
        }
        if(n == 0){
            return 0;
        }
        int root = (int)Math.sqrt(n);
        int min = Integer.MAX_VALUE;
        for(int i = root; i >= 1; i--){
            int sq = i * i;
            min = Math.min(min, helper(n - sq));
        }
        memo.put(n, 1 + min);
        return 1 + min;
    }

    public int numSquares(int n) {
        memo = new HashMap<>();
        return helper(n);
    }
}