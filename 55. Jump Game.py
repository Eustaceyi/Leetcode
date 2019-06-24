class Solution:
    def canJump(self, nums: List[int]) -> bool:
        if not nums:
            return False
        if len(nums) == 1:
                return True
        goal = len(nums) - 1 
        for i in range(len(nums)-2,-1,-1):
            if i + nums[i] >= goal:
                goal = i
        return not goal
        
class Solution:
    def canJump(self, nums: List[int]) -> bool:
        if not nums:
            return False
        if len(nums) == 1:
                return True
        m = 0
        for i in range(len(nums)):
            if i > m:
                return False
            m = max(m, i+nums[i])
        return True