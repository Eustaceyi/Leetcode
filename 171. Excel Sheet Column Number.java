class Solution {
    public int titleToNumber(String s) {
        int ans = 0, n = s.length();
        for (int i=0; i<n; i++) {
            ans += Math.pow(26, n-i-1) * (s.charAt(i) - 'A' + 1);
        }
        return ans;
    }
}