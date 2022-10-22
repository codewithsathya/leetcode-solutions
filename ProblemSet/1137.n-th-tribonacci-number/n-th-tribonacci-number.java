class Solution {
    public int tribonacci(int n) {
        if(n == 0) return 0;
        if(n == 1) return 1;
        if(n == 2) return 1;
        int[] arr = new int[n + 1];
        arr[1] = 1;
        arr[2] = 1;
        for(int i = 0; i <= n; i++){
            if(i + 1 != 2 && i + 1 <= n){
                arr[i + 1] += arr[i];
            }
            if(i + 2 <= n){
                arr[i + 2] += arr[i];
            }
            if(i + 3 <= n){
                arr[i + 3] += arr[i];
            }
        }
        return arr[n];
    }
}