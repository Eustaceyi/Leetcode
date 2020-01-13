/**
 * Classic dp solution
 * first we consider each coin,
 * this could help with get rid of repeat using of one coin
 * and for each coin, it should begin with the coin itself
 * and for next amounts, we add i - coin to find out that 
 * how many ways that it already have
 */
class Solution {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount+1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int i=coin; i<amount+1; i++) {
                dp[i] += dp[i-coin];
            }
        }
        return dp[amount];
    }
}