class Solution:
    def permute(self, nums: List[int]) -> List[List[int]]:
        results = []
        self.helper(nums, [], results)
        return results
    
    def helper(self, nums, result, results):
        if len(nums) == 1:
            results.append(result + nums)
            return
        for i in range(len(nums)):
            self.helper(nums[:i]+nums[i+1:], result+[nums[i]], results)