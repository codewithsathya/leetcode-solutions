class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if(n == 0) return true;
        if(flowerbed.length == 1){
            if(n > 1){
                return false;
            }
            return flowerbed[0] == 0;
        }
        for(int i = 0; i < flowerbed.length; i++){
            if(flowerbed[i] == 1){
                continue;
            }
            if(i - 1 >= 0){
                if(flowerbed[i - 1] == 1){
                    continue;
                }
            }
            if(i + 1 <= flowerbed.length - 1){
                if(flowerbed[i + 1] == 1){
                    continue;
                }
            }
            n--;
            flowerbed[i] = 1;
            if(n <= 0){
                return true;
            }
        }
        return false;
    }
}