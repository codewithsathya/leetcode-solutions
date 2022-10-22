class Solution {
    public int divide(int dividend, int divisor) {
        if(dividend == Integer.MIN_VALUE && divisor == -1){
            return Integer.MAX_VALUE;
        }
        int negatives = 0;
        if(dividend < 0){
            negatives++;
        }else{
            dividend = -dividend;
        }
        if(divisor < 0){
            negatives++;
        }else{
            divisor = -divisor;
        }
        int quotient = 0;
        while(dividend <= divisor){
            int power = -1;
            int value = divisor;
            while(value >= (Integer.MIN_VALUE >> 1) && (value >> 1) >= dividend){
                value >>= 1;
                power >>= 1;
            }
            quotient += power;
            dividend -= value;
        }
        if(negatives != 1){
            quotient = -quotient;
        }
        return quotient;
    }
}