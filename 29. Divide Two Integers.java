class Solution {
    public int divide(int dividend, int divisor) {
        // Careful for overflow and edge cases
        // Thought: find the most 2^k * divisor and substract that
        if (dividend == (Integer.MIN_VALUE) && divisor == -1) {
            return Integer.MAX_VALUE;
        } else if (dividend == (Integer.MIN_VALUE) && divisor == 1) {
            return Integer.MIN_VALUE;
        }
        boolean samesign = !((dividend ^ divisor) < 0);
        if (dividend > 0) {
            dividend = 0 - dividend;
        }
        if (divisor > 0) {
            divisor = 0 - divisor;
        }
        int res = 0;
        while (dividend <= divisor) {
            int d = divisor;
            int count = 0;
            while (d >= dividend) {
                if (d < (Integer.MIN_VALUE) >> 1) {
                    break;
                }
                d = d << 1;
                count++;
            }
            if (count > 0) {
                dividend = dividend - (d >> 1);
                res += Math.pow(2, count-1);
            } else {
                dividend = dividend - d;
                res += 1;
            }
            
        }
        if (!samesign) {
            res = 0 - res;
        }
        return res;
    }
}