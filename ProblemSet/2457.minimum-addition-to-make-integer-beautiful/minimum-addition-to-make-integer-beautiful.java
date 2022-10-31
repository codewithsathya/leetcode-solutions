class Solution {
    int getSum(long n){
        int sum = 0;
        while(n != 0){
           sum += n % 10;
            n /= 10;
        }
        return sum;
    }

    public long makeIntegerBeautiful(long n, int target) {
        int digitSum = getSum(n);
        long temp = n;
        int count = 0;
        while(digitSum > target){
            temp = temp / (long)Math.pow(10, count + 1);
            temp++;
            temp *= Math.pow(10, count + 1);
            count++;
            digitSum = getSum(temp);
        }
        return temp - n;
    }
}