class Solution {
    public int minPartitions(String n) {
        int ans = 0;
        for(char ch: n.toCharArray()){
            int value = Integer.valueOf(ch) - 48;
            if(value > ans){
                ans = value;
            }
        }
        return ans;
    }
}