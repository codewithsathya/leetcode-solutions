class Solution {
    public String largestNumber(int[] nums) {
        int len = nums.length;
        String[] strs = new String[len];
        for(int i = 0; i < len; i++){
            strs[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(strs, (a, b) -> (b + a).compareTo(a + b));
        StringBuilder sb = new StringBuilder();
        for(String str: strs){
            sb.append(str);
        }
        if(sb.charAt(0) == '0') return "0";
        return sb.toString();
    }
}