class Solution:
    def rob(self, nums: List[int]) -> int:
        if len(nums) == 1:
            return nums[0]
        maxmoney = [0] * (len(nums)+1)
        for i in range(len(nums)-1):
            maxmoney[i+2] = max(maxmoney[i+1], maxmoney[i]+nums[i])
        firstmax = maxmoney[-1]
        maxmoney = [0] * (len(nums)+1)
        for i in range(len(nums)-1):
            maxmoney[i+2] = max(maxmoney[i+1], maxmoney[i]+nums[i+1])
        secondmax = maxmoney[-1]
        return max(firstmax, secondmax)