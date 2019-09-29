class Solution:
    def lengthOfLIS(self, nums: List[int]) -> int:
        '''
        DP solution, for each pos check the longest seq including curr number
        return the longest one
        Time O(n^2)
        Space O(n)
        '''
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

    def lengthOfLIS(self, nums):
        '''
        DP with binary search
        Time O(nlogn)
        Space O(n)
        https://leetcode.com/problems/longest-increasing-subsequence/discuss/74824/JavaPython-Binary-search-O(nlogn)-time-with-explanation
        Hard to think
        '''
        tails = [0] * len(nums)
        size = 0
        for x in nums:
            i, j = 0, size
            while i != j:
                m = (i + j) / 2
                if tails[m] < x:
                    i = m + 1
                else:
                    j = m
            tails[i] = x
            size = max(i + 1, size)
        return size
