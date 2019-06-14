class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        if target not in nums:
            return [-1, -1]
        left = self.helper(nums, target, True)
        if left >= len(nums) or nums[left] != target:
            return [-1, -1]
        return [left, self.helper(nums, target, False)-1]
        
    def helper(self, nums, target, isleft):
        '''
        Careful about leftmost search and binary search
        '''
        left, right = 0, len(nums)
        while left < right:
            mid = (right-left)//2 + left
            if nums[mid] > target or (isleft and nums[mid] == target):
                right = mid
            else:
                left = mid + 1
        return left