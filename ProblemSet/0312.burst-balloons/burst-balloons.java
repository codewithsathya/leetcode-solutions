class Solution {
    public int maxCoins(int[] nums) {
        int len = nums.length;
        int[][] table = new int[len][len];
        for(int sublen = 1; sublen <= len; sublen++){
            for(int substart = 0; substart <= len - sublen; substart++){
                for(int k = substart; k < substart + sublen; k++){
                    int sum = 0;
                    int product = nums[k];
                    int left = substart - 1;
                    int right = substart + sublen;
                    if(left > -1){
                        product *= nums[left];
                    }
                    if(right < len){
                        product *= nums[right];
                    }
                    sum += product;

                    int leftStart = substart;
                    int leftEnd = k - 1;
                    if(leftStart < k && leftEnd >= substart){
                        sum += table[leftStart][leftEnd];
                    }
                    int rightStart = k + 1;
                    int rightEnd = substart + sublen - 1;
                    if(rightStart <= substart + sublen - 1 && rightEnd > k){
                        sum += table[rightStart][rightEnd];
                    }
                    table[substart][substart + sublen - 1] = Math.max(table[substart][substart + sublen - 1], sum);
                }
            }
        }
        return table[0][len - 1];
    }
}