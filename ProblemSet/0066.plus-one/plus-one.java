class Solution {
    public int[] plusOne(int[] digits) {
        int carry = 0;
        int i = digits.length - 1;
        do{
            digits[i] += 1;
            if(digits[i] == 10){
                carry = 1;
                digits[i] = 0;
            }else{
                carry = 0;
                break;
            }
            i--;
        }while(i >= 0 && carry == 1);
        if(carry == 1){
            int[] result = new int[digits.length + 1];
            result[0] = carry;
            for(int j = 1; j < result.length; j++){
                result[j] = digits[j - 1];
            }
            return result;
        }else{
            return digits;
        }
    }
}