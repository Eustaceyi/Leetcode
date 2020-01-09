/**
 * looping solution
 */
class Solution {
    public boolean isPowerOfThree(int n) {
        if (n <= 0) {
            return false;
        }
        while (n % 3 == 0) {
            n = n / 3;
        }
        return n == 1;
    }
}

/**
 * we know n is a int, so the max of power of 3 is 3^(log_3^max_int) = 1162261467
 * the only divisors are 3^0 3^1 ...
 */
public class Solution {
    public boolean isPowerOfThree(int n) {
        return n > 0 && 1162261467 % n == 0;
    }
}