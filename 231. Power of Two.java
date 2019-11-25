/** 
 * x & -x leaves the rightmost bit of the integer
 */
class Solution {
    public boolean isPowerOfTwo(int n) {
      if (n <= 0) return false;
      return (n & (-n)) == n;
    }
}
/**
 * x & (x-1) turn off the rightmost bit
 */
class Solution {
    public boolean isPowerOfTwo(int n) {
      if (n <= 0) return false;
      return (n & (n-1)) == 0;
    }
}
/**
 * Time O(logn) Space O(1)
 */
class Solution {
    public boolean isPowerOfTwo(int n) {
        while (n > 0) {
            int temp = n & 1;
            if (temp == 1) {
                break;
            }
            n = n >> 1;
        }
        if (n == 1) {
            return true;
        }
        return false;
    }
}