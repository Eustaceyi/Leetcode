# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def binaryTreePaths(self, root: TreeNode) -> List[str]:
        res = []
        self.dfs(root, '', res)
        return res
        
    def dfs(self, root, path, res):
        if root:
            path += str(root.val)
            if not root.left and not root.right:
                res.append(path)
            else:
                path += '->'
                self.dfs(root.left, path, res)
                self.dfs(root.right, path, res)