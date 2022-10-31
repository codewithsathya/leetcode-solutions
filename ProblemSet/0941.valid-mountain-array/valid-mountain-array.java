class Solution {
    public boolean validMountainArray(int[] arr) {
        if(arr.length < 3) return false;
        boolean negative = false;
        if(arr[1] < arr[0]) return false;
        for(int i = 1; i < arr.length; i++){
            if(arr[i] - arr[i - 1] == 0) return false;
            if(arr[i] - arr[i - 1] < 0){
                if(negative == false){
                    negative = true;
                }
            }
            if(negative && arr[i] - arr[i - 1] > 0){
                return false;
            }
        }
        return negative;
    }
}