class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        LinkedList<Integer> result = new LinkedList<>();
        int low = 0;
        int high = arr.length;
        while(low < high){
            int mid = low + (high - low) / 2;
            if(arr[mid] > x){
                high = mid - 1;
            }else if(arr[mid] < x){
                low = mid + 1;
            }else{
                low = mid;
                break;
            }
        }
        if(low == arr.length){
            low = low - 1;
        }

        int closest = low;
        if(low > 0){
             if(Math.abs(arr[low - 1] - x) <= Math.abs(arr[low] - x)){
                closest = low - 1;
             }
        }
        if(low < arr.length - 1){
            if(Math.abs(arr[low + 1] - x) < Math.abs(arr[closest] - x)){
                closest = low + 1;
            }
        }

        result.add(arr[closest]);
        int left = closest - 1;
        int right = closest + 1;
        for(int i = 0; i < k - 1; i++){
            if(left < 0){
                if(right >= arr.length) return result;
                result.add(arr[right++]);
            }else if(right >= arr.length){
                if(left < 0) return result;
                result.addFirst(arr[left--]);
            }else{
                if(Math.abs(arr[right] - x) < Math.abs(arr[left] - x)){
                    result.add(arr[right++]);
                }else{
                    result.addFirst(arr[left--]);
                }
            }
        }
        return result;
    }
}