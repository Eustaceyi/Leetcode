# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def widthOfBinaryTree(self, root: TreeNode) -> int:
        queue = [(root, 0, 0)]
        curr_level, left, ans = 0,0,0
        for node, level, pos in queue:
            if node:
                queue.append((node.left, level+1, 2*pos))
                queue.append((node.right, level+1, 2*pos+1))
                if level != curr_level:
                    curr_level = level
                    left = pos
                ans = max(ans, pos-left+1)
        return ans