class Solution {
    public int value(char c){
        if(c == 'I')
            return 1;
        if(c == 'V')
            return 5;
        if(c == 'X')
            return 10;
        if(c == 'L')
            return 50;
        if(c == 'C')
            return 100;
        if(c == 'D')
            return 500;
        if(c == 'M')
            return 1000;
        return -1;
    }
    public int romanToInt(String s) {
        int res = 0;
        for(int i = 0; i < s.length(); ++i){
            int val1 = value(s.charAt(i));
            if(i + 1 < s.length()){
                int val2 = value(s.charAt(i + 1));
                if(val1 >= val2)
                    res += val1;
                else {
                    res += (val2 - val1);
                    ++i;
                }
            }else{
                res += val1;
            }
        }
        return res;
    }
}