/**
 * greedy + dp, for each pos we find if nums[i] + two step before larger or one step before is larger
 */
class Solution {
    public int rob(int[] nums) {
        if (nums==null || nums.length==0) {
            return 0;
        }
        int[] dp = new int[nums.length+2];
        dp[0] = 0;
        dp[1] = 0;
        for (int i=2; i<dp.length; i++) {
            dp[i] = Math.max(nums[i-2]+dp[i-2], dp[i-1]);
        }
        return dp[dp.length-1];
    }
}