class Solution {
    public int myAtoi(String s) {
        s = s.trim();
        boolean isNegative = false;
        String str = "";
        if (s.indexOf("+") > -1) {
            isNegative = false;
        }
        if (s.indexOf("-") > -1 && s.indexOf("-") != s.length() - 1) {
            isNegative = true;
        }

        boolean sign = false;
        for (char ch : s.toCharArray()) {
            if (ch >= 48 && ch <= 57) {
                sign = true;
                str += ch;
            } else if ((ch == '+' || ch == '-') && !sign) {
                sign = true;
                continue;
            } else {
                break;
            }
            if (str.length() == 0)
                continue;
            long value = Long.valueOf(str);
            if (isNegative) {
                if (-value <= Integer.MIN_VALUE) {
                    return Integer.MIN_VALUE;
                }
            } else {
                if (value > Integer.MAX_VALUE) {
                    return Integer.MAX_VALUE;
                }
            }
        }
        if (str.length() == 0)
            return 0;
        int result = Integer.valueOf(str);
        return isNegative ? -result : result;
    }
}