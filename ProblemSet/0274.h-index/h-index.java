class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        for(int i = 1; i <= citations.length; ++i){
            if(citations[citations.length - i] < i) return i - 1;
        }
        return citations.length;
    }
}