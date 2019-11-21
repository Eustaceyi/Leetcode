class Solution {
    public int trailingZeroes(int n) {
        int ans = 0;
        int div = 5;
        while (n >= div) {
            ans += n/div;
            n /= 5;
        }
        return ans;
    }
}

class Solution {
    public int trailingZeroes(int n) {
        return n == 0 ? 0 : n/5 + trailingZeroes(n/5);
    }
}