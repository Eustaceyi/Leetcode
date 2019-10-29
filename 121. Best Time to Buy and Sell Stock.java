class Solution {
    public int maxProfit(int[] prices) {
        int currmax=0, totalmax=0;
        for (int i=1; i<prices.length; i++) {
            currmax = Math.max(currmax+prices[i]-prices[i-1], prices[i]-prices[i-1]);
            totalmax = Math.max(totalmax, currmax);
        }
        return totalmax;
    }
}