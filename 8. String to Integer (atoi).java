class Solution {
    public int myAtoi(String str) {
        str = str.trim();
        int result = 0;
        int sign = 1;
        for (int i=0; i<str.length(); i++) {
            if (str.charAt(i)=='+' || str.charAt(i)=='-') {
                if (i!=0) {
                    return sign * result;
                } else {
                    sign = str.charAt(i)=='+' ? 1 : -1;
                }
            } else if (Character.isDigit(str.charAt(i))) {
                int temp = str.charAt(i) - '0';
                if (result * sign > Integer.MAX_VALUE/10 || (result * sign == Integer.MAX_VALUE/10 && temp > 7)) {
                    return Integer.MAX_VALUE;
                } else if (result * sign < Integer.MIN_VALUE/10 || (result * sign == Integer.MIN_VALUE/10 && temp > 8)) {
                    return Integer.MIN_VALUE;
                } else {
                    result = result * 10 + temp;
                }
            } else {
                return sign * result;
            }
        }
        return sign * result;
    }
}