class Solution:
    def maxProduct(self, nums: List[int]) -> int:
        '''
        keep tracking of max and min will be fine
        '''
        currMax, currMin, ans = nums[0], nums[0], nums[0]
        for i in nums[1:]:
            currMax, currMin = max(i, i*currMax, i*currMin), min(i, i*currMax, i*currMin)
            ans = max(ans, currMax)
        return ans