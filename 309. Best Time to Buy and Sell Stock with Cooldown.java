/**
 * DP solution,
 * consider the two states, we can buy in with sold two days ago
 * so the curr day (b0) we could choose keep last day (b1) or buy in with sell at two days ago (s2)
 * we could also not selling last buy by keeping s1 or sell what we buy (b1)
 */
class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length < 2) {
            return 0;
        }
        int b0 = -prices[0], b1 = b0;
        int s0 = 0, s1 = 0, s2 = 0;
        for (int i=1; i<prices.length; i++) {
            b0 = Math.max(b1, s2 - prices[i]);
            s0 = Math.max(s1, b1 + prices[i]);
            b1 = b0;
            s2 = s1;
            s1 = s0;
        }
        return s0;
    }
}