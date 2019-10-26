class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid==null || obstacleGrid.length==0 || obstacleGrid[0][0]==1) {
            return 0;
        }
        int m = obstacleGrid[0].length;
        int n = obstacleGrid.length;
        int[] dp = new int[m];
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (i==0) {
                    dp[j] = obstacleGrid[i][j] == 1 || (j>0 && dp[j-1]==0) ? 0 : 1;
                } else {
                    if (obstacleGrid[i][j] == 1) {
                        dp[j] = 0;
                    } else {
                        if (j==0) {
                            dp[j] = dp[j] == 0 ? 0 : 1;
                        } else {
                            dp[j] += dp[j-1];
                        }
                    }
                }
            }
        }
        return dp[m-1];
    }
}