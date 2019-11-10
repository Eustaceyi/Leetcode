/**
 * recursive fast pow
 * O(logn) time and space
 */
class Solution {
    public double myPow(double x, int n) {
        if (n<0) {
            x = 1/x;
            n = -n;
        }
        return fastPow(x, n);
    }
    private double fastPow(double x, int n) {
        if (n==0) {
            return 1.0;
        }
        double half = fastPow(x, n/2);
        if (n%2==0) {
            return half * half;
        } else {
            return half * half * x;
        }
    }
}

/**
 * Find all '1' bit in n, and multiply the ans with x^(2^pos)
 * Time O(logn)
 * Space O(1)
 */
class Solution {
    public double myPow(double x, int n) {
        if (n<0) {
            x = 1/x;
            n = -n;
        }
        double ans = 1.0;
        double curr = x;
        for (int i=n; i>0; i/=2) {
            if (i%2==1) {
                ans = ans * curr;
            }
            curr = curr * curr;
        }
        return ans;
    }
}