class Solution {
    public int mySqrt(int x) {
        if(x == 0 || x == 1) return x;
        int result = 1;
        int i = 1;
        while(result <= x){
            i++;
            result = i * i;
        }
        return i - 1;
    }
}