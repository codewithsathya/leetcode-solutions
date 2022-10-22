class Solution {
    Map<Integer, Double> memo = new HashMap<>();
    public double myPow(double x, int n) {
        if(n == Integer.MIN_VALUE){
            return myPow(x, n + 1) / x;
        }
        if(x == 1) return 1;
        if(memo.containsKey(n)) return memo.get(n);
        if(n == 0) return 1;
        if(n < 0) return (1 / myPow(x, -n));
        else{
            int first = n / 2;
            int second = n - 1 - first;
            double ans = x * myPow(x, first) * myPow(x, second);
            memo.put(n, ans);
            return ans;
        } 
    }
}