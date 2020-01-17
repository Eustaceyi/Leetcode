/**
 * Dp solution
 * first thing we need to consider is that if the sum of all array
 * can be split into two parts
 * then we want to find the combination that could help with sum up to
 * half sum
 */
class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 == 1) {
            return false;
        }
        sum /= 2;
        
        boolean[] dp = new boolean[sum+1];
        dp[0] = true;
        for (int num : nums) {
            // we do it from reverse could help with get rid of 
            // using a number multiple times
            for (int i = sum; i>= num; i--) {
                dp[i] = dp[i] || dp[i-num];
            }
        }
        return dp[sum];
    }
}