class Solution:
    def permuteUnique(self, nums: List[int]) -> List[List[int]]:
        nums.sort()
        results = []
        self.helper(nums, [], results)
        return results
    
    def helper(self, nums, result, results):
        if len(nums) == 1:
            results.append(result + nums)
            return
        i = 0
        while i < len(nums):
            if i > 0 and nums[i-1] == nums[i]:
                i += 1
                continue
            self.helper(nums[:i]+nums[i+1:], result+[nums[i]], results)
            i += 1