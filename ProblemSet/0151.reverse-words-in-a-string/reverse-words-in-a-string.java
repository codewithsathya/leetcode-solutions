class Solution {
    public String reverseWords(String s) {
        s = s.trim();
        String[] arr = s.split("\\s+");
        String result = "";
        for(int i = arr.length - 1; i >= 0; i--){
            String str = arr[i];
            result += str;
            if(i != 0){
                result += " ";
            }
        }
        return result;
    }
}