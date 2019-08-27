# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None


class Solution:
    '''
    DFS with recursion
    '''
    def sumNumbers(self, root: TreeNode) -> int:
        self.results = 0
        self.dfs(root, 0)
        return self.results
        
    def dfs(self, root, value):
        if root:
            self.dfs(root.left, value*10+root.val)
            self.dfs(root.right, value*10+root.val)
            if not root.left and not root.right:
                self.results += value*10 + root.val