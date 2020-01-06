class Solution:
    def nextGreaterElements(self, nums: List[int]) -> List[int]:
        if not nums:
            return []
        n = len(nums)
        res = [-1] * n
        stack = []
        for i in range(n):
            if not stack:
                stack.append(i)
            else:
                while len(stack) > 0 and nums[stack[-1]] < nums[i]:
                    res[stack.pop()] = nums[i]
                stack.append(i)
        for i in range(n):
            while len(stack) > 0 and nums[stack[-1]] < nums[i]:
                res[stack.pop()] = nums[i]
        return res