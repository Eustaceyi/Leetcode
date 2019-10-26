class Solution {
    public int uniquePaths(int m, int n) {
        int[] dp = new int[m];
        for (int j=0; j<n; j++) {
            for (int i=0; i<m; i++) {
                if (j==0) {
                    dp[i] = 1;
                } else {
                    if (i==0) {
                        dp[i] = 1;
                    } else {
                        dp[i] = dp[i] + dp[i-1];
                    }
                }
            }
        }
        return dp[m-1];
    }
}