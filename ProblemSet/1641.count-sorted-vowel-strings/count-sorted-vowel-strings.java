class Solution {
    public int countVowelStrings(int n) {
        int[] table = new int[5];
        Arrays.fill(table, 1);
        for(int i = 2; i <= n; i++){
            for(int j = 1; j < 5; j++){
                table[j] += table[j - 1];
            }
        }
        int sum = 0;
        for(int num: table){
            sum += num;
        }
        return sum;
    }
}