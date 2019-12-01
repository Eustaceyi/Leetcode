class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        for (int i=1; i<=amount; i++) {
            int temp = Integer.MAX_VALUE;
            for (int coin : coins) {
                if (i-coin >= 0 && dp[i-coin] >= 0) {
                    temp = Math.min(dp[i-coin], temp);
                }
            }
            if (temp == Integer.MAX_VALUE) {
                dp[i] = -1;
            } else {
                dp[i] = temp+1;
            }
        }
        return dp[amount];
    }
}