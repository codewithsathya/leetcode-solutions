class Solution {
    int large = 101;
    public void reverse(int[] arr, int start, int end){
        for(int i = start; i <= end; i++){
            arr[i] = (arr[end + start - i] % large) * large + arr[i];
        }
        for(int i = start; i <= end; i++){
            arr[i] /= large;
        }
    }

    public void swap(int[] arr, int i, int j){
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }

    public void nextPermutation(int[] nums) {
        int p = nums.length - 1;
        while(p > 0 && nums[p] <= nums[p - 1]){
            p--;
        }
        int pivot = p - 1;
        if(pivot >= 0){
            for(int i = nums.length - 1; i >= p; i--){
                if(nums[i] > nums[pivot]){
                    swap(nums, i, pivot);
                    break;
                }
            }
        }
        reverse(nums, p, nums.length - 1);
    }
}