class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        results = []
        self.dfs(nums, 0, [], results)
        return results
        
    def dfs(self, nums, k, result, results):
        results.append(result)
        for i in range(k, len(nums)):
            self.dfs(nums, i+1, result+[nums[i]],results)

class Solution:
    def subsets(self, nums):
        res = [[]]
        for num in nums:
            res += [item+[num] for item in res]
        return res