# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def isSymmetric(self, root: TreeNode) -> bool:
        if not root or not root.left and not root.right:
            return True
        if not root.left or not root.right:
            return False
        return self.helper(root.left, root.right)
        
    def helper(self, p, q):
        if not p and not q:
            return True
        if not p or not q:
            return False
        return p.val == q.val and self.helper(p.left, q.right) and self.helper(q.left, p.right)