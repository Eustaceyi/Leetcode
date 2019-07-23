# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def flatten(self, root: TreeNode) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        if not root:
            return root
        res = []
        self.helper(root, res)
        for i in range(len(res)-1):
            res[i].right = res[i+1]
            res[i].left = None
        res[-1].left = None
        res[-1].right = None
        
    def helper(self, root, res):
        if not root:
            return
        res.append(root)
        self.helper(root.left, res)
        self.helper(root.right, res)