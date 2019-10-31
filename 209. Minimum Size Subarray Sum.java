/**
 * Use two pointers to keep track of the subarray
 * Time O(n)
 * Space O(1)
 */
class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        if (nums==null || nums.length==0) {
            return 0;
        }
        int slow = 0, sum = 0, minlen = nums.length+1;
        for (int fast=0; fast<nums.length; fast++) {
            sum += nums[fast];
            while (sum >= s) {
                minlen = Math.min(minlen, fast-slow+1);
                sum -= nums[slow++];
            }
        }
        if (minlen == nums.length+1) {
            return 0;
        }
        return minlen;
    }
}