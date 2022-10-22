class Solution {
    public boolean isHappy(int n) {
        if(n == 1) return true;
        Set<Integer> visited = new HashSet<>();
        visited.add(n);
        int sum = 0;
        while(sum != 1){
            sum = getSum(n);
            if(visited.contains(sum)) return false;
            n = sum;
            visited.add(sum);
        }
        return true;
    }

    private int getSum(int n){
        int sum = 0;
        while(n > 0){
            int digit = n % 10;
            sum += (digit * digit);
            n /= 10;
        }
        return sum;
    }
}