class Solution:
    def fourSum(self, nums: List[int], target: int) -> List[List[int]]:
        '''
        This is a universal NSum method. First we need to sort and call the helper func.
        The helper discuss when N == 2 or others, and reduce others into N == 2
        '''
        nums.sort()
        results = []
        self.NSum(nums, target, 4, [], results)
        return results
        
    def NSum(self, nums, target, N, result, results):
        if len(nums) < N or N < 2:
            return
        
        if N == 2:
            l, r = 0, len(nums)-1
            while l < r:
                if nums[l] + nums[r] > target:
                    r -= 1
                    while r > l and nums[r+1] == nums[r]:
                        r -= 1
                elif nums[l] + nums[r] < target:
                    l += 1
                    while l < r and nums[l-1] == nums[l]:
                        l += 1
                elif nums[l] + nums[r] == target:
                    results.append(result + [nums[l], nums[r]])
                    l += 1
                    r -= 1
                    while r > l and nums[r+1] == nums[r]:
                        r -= 1
                    while l < r and nums[l-1] == nums[l]:
                        l += 1
        else:
            for i in range(len(nums) - N + 1):
                if nums[i] * N > target or nums[-1] * N < target:
                    return
                if i > 0 and nums[i] == nums[i-1]:
                    continue
                self.NSum(nums[i+1:], target-nums[i], N-1, result + [nums[i]], results)