class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        if (dungeon == null || dungeon.length == 0 || dungeon[0].length == 0) {
            return 0;
        }
        int M = dungeon.length;
        int N = dungeon[0].length;
        int[][] dp = new int[M][N];
        for (int i = M-1; i >= 0; i--) {
            for (int j = N-1; j >= 0; j--) {
                if (i == M-1 && j == N-1) {
                    dp[i][j] = dungeon[i][j] >= 0 ? 1 : 1 - dungeon[i][j];
                } else if (i == M-1) {
                    int temp = dp[i][j+1] - dungeon[i][j];
                    if (temp <= 0) {
                        temp = 1;
                    }
                    dp[i][j] = temp;
                } else if (j == N-1) {
                    int temp = dp[i+1][j] - dungeon[i][j];
                    if (temp <= 0) {
                        temp = 1;
                    }
                    dp[i][j] = temp;
                } else {
                    int temp = dp[i][j+1] - dungeon[i][j];
                    if (temp <= 0) {
                        temp = 1;
                    }
                    dp[i][j] = temp;
                    temp = dp[i+1][j] - dungeon[i][j];
                    if (temp <= 0) {
                        temp = 1;
                    }
                    dp[i][j] = Math.min(temp, dp[i][j]);
                }
            }
        }
        return dp[0][0];
    }
}