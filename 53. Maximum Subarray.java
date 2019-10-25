class Solution {
    /**
     * Greedy approach
     * Time O(n)
     * Space O(1)
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int currSum=nums[0], totalSum=nums[0];
        for (int i=1;i<nums.length;i++) {
            currSum = Math.max(nums[i], currSum + nums[i]);
            totalSum = Math.max(totalSum, currSum);
        }
        return totalSum;
    }
}