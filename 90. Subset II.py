class Solution:
    def subsetsWithDup(self, nums: List[int]) -> List[List[int]]:
        '''
        Iterative method
        '''
        result = [[]]
        for i in sorted(nums):
            result += [item + [i] for item in result if item + [i] not in result]
        return result

class Solution:
    def subsetsWithDup(self, nums: List[int]) -> List[List[int]]:
        '''
        DFS solution
        '''
        results = []
        nums.sort()
        for i in range(len(nums)+1):
            self.helper(i, nums, [], results)
        return results
        
    def helper(self, num, nums, result, results):
        if num == 0:
            results.append(result)
            return
        for j in range(len(nums)):
            if j > 0 and nums[j] == nums[j-1]:
                continue
            self.helper(num-1, nums[j+1:], result+[nums[j]], results)