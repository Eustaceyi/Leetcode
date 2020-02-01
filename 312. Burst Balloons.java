class Solution {
    public int maxCoins(int[] nums) {
        if (nums==null || nums.length==0) {
            return 0;
        }
        int[] n = new int[nums.length+2];
        n[0] = 1; n[n.length-1] = 1;
        for (int i=1; i<=nums.length; i++) {
            n[i] = nums[i-1];
        }
        int[][] dp = new int[n.length][n.length];
        for (int i = 2; i<n.length; i++) {
            for (int j=i-2; j>=0; j--) {
                for (int k=j+1; k<i; k++) {
                    dp[j][i] = Math.max(dp[j][i], dp[j][k] + dp[k][i] + n[i]*n[j]*n[k]);
                }
            }
        }
        return dp[0][n.length-1];
    }
}