# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def closestValue(self, root: TreeNode, target: float) -> int:
        res = float('inf')
        store = None
        while root:
            if root.val > target:
                if res > root.val - target:
                    store = root.val
                    res = root.val - target
                root = root.left
            else:
                if res > target - root.val:
                    store = root.val
                    res = target - root.val
                root = root.right
        return store