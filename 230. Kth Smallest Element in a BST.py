# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def kthSmallest(self, root: TreeNode, k: int) -> int:
        inor = []
        self.helper(root, inor)
        return inor[k-1]
        
    def helper(self, root, l):
        if not root:
            return
        self.helper(root.left, l)
        l.append(root.val)
        self.helper(root.right, l)
        
class Solution:
    def kthSmallest(self, root: TreeNode, k: int) -> int:
        stack = []
        while 1:
            while root:
                stack.append(root)
                root = root.left
            root = stack.pop()
            k -= 1
            if k == 0:
                return root.val
            root = root.right