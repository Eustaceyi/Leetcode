# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def countUnivalSubtrees(self, root: TreeNode) -> int:
        if not root:
            return 0
        self.count = 0
        self.counttree(root)
        return self.count
    
    def counttree(self, root):
        if not root.left and not root.right:
            self.count += 1
            return root.val
        elif not root.left:
            if root.val == self.counttree(root.right):
                self.count += 1
                return root.val
            else:
                return
        elif not root.right:
            if root.val == self.counttree(root.left):
                self.count += 1
                return root.val
            else:
                return
        else:
            left = self.counttree(root.left)
            right = self.counttree(root.right)
            if root.val == left and root.val == right:
                self.count += 1
                return root.val
            else:
                return