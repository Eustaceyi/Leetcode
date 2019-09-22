class Solution {
    public boolean isPalindrome(int x) {
        if (x<0 || (x%10==0 && x!=0)) {
            return false;
        }
        int rev = 0;
        int store = x;
        int mod = 0;
        while (x != 0) {
            mod = x % 10;
            x = x/10;
            rev = rev*10+mod;
        }
        return store == rev;
    }
}