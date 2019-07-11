# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    '''
    recursion version
    '''
    def inorderTraversal(self, root: TreeNode) -> List[int]:
        res = []
        self.inorder(root, res)
        return res
        
    def inorder(self, root, ls):
        if root:
            self.inorder(root.left, ls)
            ls.append(root.val)
            self.inorder(root.right, ls)

class Solution:
    '''
    Iteration method
    '''
    def inorderTraversal(self, root: TreeNode) -> List[int]:
        res, stack = [], []
        while 1:
            while root:
                stack.append(root)
                root = root.left
            if not stack:
                return res
            root = stack.pop()
            res.append(root.val)
            root = root.right