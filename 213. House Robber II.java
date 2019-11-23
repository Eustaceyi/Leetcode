class Solution {
    public int rob(int[] nums) {
        int ans = 0;
        if (nums==null || nums.length==0) {
            return ans;
        } else if (nums.length==1) {
            return nums[0];
        }
        int[] dp = new int[nums.length+1];
        dp[0] = 0; dp[1] = 0;
        for (int i=0; i<nums.length-1; i++) {
            dp[i+2] = Math.max(dp[i]+nums[i], dp[i+1]);
        }
        ans = dp[dp.length-1];
        dp[0] = 0; dp[1] = 0;
        for (int i=1; i<nums.length; i++) {
            dp[i+1] = Math.max(dp[i-1]+nums[i], dp[i]);
        }
        return Math.max(ans, dp[dp.length-1]);
    }
}