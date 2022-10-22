class Solution {
    public int countPrimes(int n) {
        boolean[] notPrime = new boolean[n];
        long no = n;
        int count = 0;
        for(int i = 2; i < n; i++){
            if(!notPrime[i]){
                count++;
                for(int j = i; (long)j * (long)i < no; j++){
                    notPrime[i * j] = true;
                }
            }
        }
        return count;
    }
}