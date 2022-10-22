class Solution {
    public int[] minOperations(String boxes) {
        int len = boxes.length();
        int[] result = new int[len];
        Arrays.fill(result, 0);
        int operations = 0;
        int count = 0;
        for(int i = 0; i < len; i++){
            result[i] = count + operations;
            operations += count;
            if(boxes.charAt(i) == '1'){
                count++;
            }
        }
        operations = count = 0;
        for(int i = len - 1; i >= 0; i--){
            result[i] += count + operations;
            operations += count;
            if(boxes.charAt(i) == '1'){
                count++;
            }
        }
        return result;
    }
}