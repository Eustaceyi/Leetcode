class Solution:
    def lengthOfLIS(self, nums: List[int]) -> int:
        if not nums:
            return 0
        dp = [0 for i in range(len(nums))]
        dp[0] = 1
        for i in range(1, len(nums)):
            currmax = 0
            for j in range(i):
                if nums[j] < nums[i]:
                    currmax = max(currmax, dp[j])
            dp[i] = currmax+1
        return max(dp)