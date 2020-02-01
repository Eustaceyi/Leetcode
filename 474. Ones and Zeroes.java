class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        if (strs==null || strs.length==0) {
            return 0;
        }
        int[][] dp = new int[m+1][n+1];
        for (int i=1; i<=strs.length; i++) {
            int ones = 0, zeros = 0;
            for (char c : strs[i-1].toCharArray()) {
                if (c == '1') {ones++;} 
                else {zeros++;}
            }
            for (int j=m; j>=zeros; j--) {
                for (int k=n; k>=ones; k--) {
                    dp[j][k] = Math.max(dp[j][k], dp[j-zeros][k-ones]+1);
                }
            }
        }
        return dp[m][n];
    }
}

class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        if (strs==null || strs.length==0) {
            return 0;
        }
        int[][][] dp = new int[strs.length+1][m+1][n+1];
        for (int i=1; i<=strs.length; i++) {
            int ones = 0, zeros = 0;
            for (char c : strs[i-1].toCharArray()) {
                if (c == '1') {ones++;} 
                else {zeros++;}
            }
            for (int j=0; j<=m; j++) {
                for (int k=0; k<=n; k++) {
                    
                    if (j>=zeros && k>=ones) {
                        dp[i][j][k] = Math.max(dp[i-1][j][k], dp[i-1][j-zeros][k-ones]+1);
                    } else {
                        dp[i][j][k] = dp[i-1][j][k];
                    }
                }
            }
        }
        return dp[strs.length][m][n];
    }
}