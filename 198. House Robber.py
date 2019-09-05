class Solution:
    def rob(self, nums: List[int]) -> int:
        '''
        the max value at this point is either the previous max or the prev of prev add curr
        '''
        prevmax = [0, 0]
        for i in range(len(nums)):
            prevmax.append(max(prevmax[i]+nums[i], prevmax[i+1]))
        return prevmax[-1]