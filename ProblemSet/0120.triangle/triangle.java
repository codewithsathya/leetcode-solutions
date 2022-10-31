class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int len = triangle.size();
        int[] sum = new int[len];
        for(int i = 0; i < len; i++){
            sum[i] = triangle.get(len - 1).get(i);
        }
        for(int i = len - 2; i >= 0; --i){
            for(int j = 0; j <= i; j++){
                sum[j] = Math.min(sum[j], sum[j + 1]);
                sum[j] += triangle.get(i).get(j);
            }
        }
        return sum[0];
    }
}