class Solution:
    def maxSubArray(self, nums: List[int]) -> int:
        if not nums:
            return
        if len(nums) == 1:
            return nums[0]
        curr_max, total_max = 0, -2**31
        for i in range(len(nums)):
            curr_max = max(curr_max+nums[i], nums[i])
            total_max = max(curr_max, total_max)
        return total_max