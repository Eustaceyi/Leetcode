# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def longestConsecutive(self, root: TreeNode) -> int:
        if not root:
            return 0
        return max(self.dfs(root.left, root.val, 1), self.dfs(root.right, root.val, 1))
        
        
    def dfs(self, node, prev_value, length):
        if not node:
            return length
        if node.val == prev_value+1:
            return max(self.dfs(node.left, node.val, length+1), self.dfs(node.right, node.val, length+1))
        else:
            return max(length, self.dfs(node.left, node.val, 1), self.dfs(node.right, node.val, 1))