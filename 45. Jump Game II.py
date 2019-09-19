class Solution:
    def jump(self, nums: List[int]) -> int:
        '''
        the thought is:
        1. get the nearest and the furthest pos from the last step
        2. calculate the furthest of this step
        3. the nearest of this step should be the futrhest from last + 1
        '''
        if len(nums) <= 1:
            return 0
        start, end, maxend = 0, 0, 0
        step = 0
        while True:
            step += 1
            for i in range(start, end+1):
                if i + nums[i] >= len(nums)-1:
                    return step
                maxend = max(maxend, i+nums[i])
            start, end = end+1, maxend