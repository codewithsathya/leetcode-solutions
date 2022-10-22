class Solution {
    public int fib(int n) {
        int[] arr = new int[n + 1];
        if(n == 0) return 0;
        if(n == 1) return 1;
        arr[1] = 1;
        for(int i = 0; i < n; i++){
            if(i + 1 <= n)
                arr[i + 1] += arr[i];
            if(i + 2 <= n)
                arr[i + 2] += arr[i];
        }
        return arr[n];
    }
}