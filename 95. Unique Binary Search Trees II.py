# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def generateTrees(self, n: int) -> List[TreeNode]:
        if n == 0:
            return []
        return self.helper(1, n)
        
    def helper(self, start, end):
        if start > end:
            return [None]
        res = []
        for i in range(start, end+1):
            left_part = self.helper(start, i-1)
            right_part = self.helper(i + 1, end)
            
            for l in left_part:
                for r in right_part:
                    root = TreeNode(i)
                    root.left = l
                    root.right = r
                    res.append(root)
        return res