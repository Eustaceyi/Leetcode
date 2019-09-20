class Solution {
    public int reverse(int x) {
        long result = 0;
        boolean neg = x < 0 ? true : false;
        long temp = Math.abs((long)x);
        long mod = 0;
        while (temp > 0) {
            mod = temp % 10;
            temp = temp / 10;
            result = result*10 + mod;
        }
        if (neg && -1 * result < -1*(long)Math.pow(2, 31)) {
            return 0;
        } else if (!neg && result > (long)Math.pow(2, 31)-1) {
            return 0;
        } else {
            int res = Math.toIntExact(result);
            if (neg) {
                res = -1 * res;
            }
            return res;
        }
    }
}

class Solution {
    public int reverse(int x) {
        // more concise version
        int result = 0;
        int mod = 0;
        while (x != 0) {
            mod = x % 10;
            x /= 10;
            if (result > Integer.MAX_VALUE/10 || (result == Integer.MAX_VALUE/10 && mod > 7)) {
                return 0;
            } else if (result < Integer.MIN_VALUE/10 || (result == Integer.MIN_VALUE/10 && mod < -8)) {
                return 0;
            }
            result = result * 10 + mod;
        }
        return result;
    }
}