# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def longestUnivaluePath(self, root: TreeNode) -> int:
        '''
        This question is hard to follow, come back later
        '''
        total, single = self.helper(root)
        return total
    
    def helper(self, root):
        if not root or not root.left and not root.right:
            return 0, 0
        total = single = 0
        if root.left:
            t, s = self.helper(root.left)
            total = t
            if root.left.val == root.val:
                total = max(total, s+1)
                single = s + 1
        if root.right:
            t, s = self.helper(root.right)
            total = max(total, t)
            if root.right.val == root.val:
                total = max(total, single + s + 1)
                single = max(single, s+1)
        return total, single