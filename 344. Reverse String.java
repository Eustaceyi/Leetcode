class Solution {
    public void reverseString(char[] s) {
        int lo = 0, hi = s.length-1;
        while (hi > lo) {
            char c = s[lo];
            s[lo] = s[hi];
            s[hi] = c;
            lo++; hi--;
        }
    }
}