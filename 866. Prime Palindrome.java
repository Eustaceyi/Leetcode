/**
 * Here we use the imporved brute force,
 * we loop each number and we first check if it is palindrome
 * and if it is we check if it is a prime
 * key point: None of 8 digit numbers is prime, so we could skip them 
 */
class Solution {
    public int primePalindrome(int N) {
        for (int ans = N; ans<2*(int)Math.pow(10, 8); ans++) {
            if (ans >= 10000000 && ans < 100000000) {
                ans = 100000000;
                continue;
            }
            if (isPal(ans) && isPrime(ans)) {
                return ans;
            }
        }
        return 0;
    }
    
    private boolean isPal(int x) {
        int temp = x, rev = 0;
        while (x != 0) {
            rev = rev * 10 + x % 10;
            x = x / 10;
        }
        if (rev == temp) {
            return true;
        } else {
            return false;
        }
    }
    
    private boolean isPrime(int x) {
        if (x < 2) {
            return false;
        }
        if (x == 2) {
            return true;
        }
        int sq = (int) Math.sqrt(x);
        for (int i=2; i <= sq; i++) {
            if (x % i == 0) {
                return false;
            }
        }
        return true;
    }
}