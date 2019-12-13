/**
 * make a dp array to record the longest pal sub seq from i to j
 * and we update:
 * 1. if s[i] == s[j] we can add 2 to the dp[i+1][j-1]
 * 2. if s[i] != s[j] we should pick the longest from dp[i][j-1] and dp[i+1][j]
 */
class Solution {
    public int longestPalindromeSubseq(String s) {
        if (s==null || s.length()==0) {
            return 0;
        }
        int len = s.length();
        int[][] dp = new int[len][len];
        for (int i=len-1; i>=0; i--) {
            dp[i][i] = 1;
            for (int j=i+1; j<len; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i+1][j-1]+2;
                } else {
                    dp[i][j] = Math.max(dp[i][j-1], dp[i+1][j]);
                }
            }
        }
        return dp[0][len-1];
    }
}