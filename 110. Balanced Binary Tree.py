# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    '''
    based on maxDepth and add early stop
    '''
    def isBalanced(self, root: TreeNode) -> bool:
        if not root:
            return True
        if self.maxDepth(root) == -1:
            return False
        return True
    
    def maxDepth(self, root: TreeNode) -> int:
        if not root:
            return 0
        left = self.maxDepth(root.left)
        right = self.maxDepth(root.right)
        if abs(left-right) > 1 or left == -1 or right == -1:
            return -1
        return max(left, right)+1