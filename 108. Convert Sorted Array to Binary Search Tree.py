# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def sortedArrayToBST(self, nums: List[int]) -> TreeNode:
        if not nums:
            return 
        elif len(nums) == 1:
            return TreeNode(nums[0])
        else:
            return self.helper(nums, 0, len(nums)-1)
    
    def helper(self, nums, lo, hi):
        if lo > hi or lo < 0 or hi > len(nums)-1:
            return 
        elif lo == hi:
            return TreeNode(nums[lo])
        else:
            mid = (hi - lo) // 2 + lo
            node = TreeNode(nums[mid])
            node.left = self.helper(nums, lo, mid-1)
            node.right = self.helper(nums, mid+1, hi)
        return node