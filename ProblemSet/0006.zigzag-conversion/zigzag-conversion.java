class Solution {
    public String convert(String s, int numRows) {
        if(numRows == 1) return s;
        int n = s.length();
        int[] map = new int[n];
        boolean goUp = true;
        int temp = 0;
        for(int i = 0; i < n; i++){
            if(temp == numRows){
                goUp = false;
                temp -= 2;
            }else if(temp == -1){
                goUp = true;
                temp += 2;
            }
            if(goUp){
                map[i] = temp;
                temp++;
            }else{
                map[i] = temp;
                temp--;
            }
        }

        String[] arr = new String[numRows];
        Arrays.fill(arr, "");
        for(int i = 0; i < n; i++){
            arr[map[i]] += s.charAt(i);
        }
        String result = "";
        for(String str: arr){
            result += str;
        }
        return result;
    }
}