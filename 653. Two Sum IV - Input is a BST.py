# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def findTarget(self, root: TreeNode, k: int) -> bool:
        stack = []
        l = []
        node = root
        while stack or node:
            while node:
                stack.append(node)
                node = node.left
            node = stack.pop()
            l.append(node.val)
            node = node.right
        
        lo, hi = 0, len(l)-1
        while lo < hi:
            if l[lo] + l[hi] == k:
                return True
            elif l[lo] + l[hi] > k:
                hi -= 1
            else:
                lo += 1
        return False
                