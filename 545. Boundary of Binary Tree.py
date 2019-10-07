# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def boundaryOfBinaryTree(self, root: TreeNode) -> List[int]:
        '''
        Time O(n)
        Space O(n) if we count all list to return
        '''
        if not root:
            return []
        self.res = []
        self.rig = []
        self.le = []
        self.findleftmost(root.left)
        self.findrightmost(root.right)
        self.findleaf(root.left)
        self.findleaf(root.right)
        
        return [root.val] + self.res + self.le + self.rig[::-1]
        
    def findleftmost(self, node):
        if not node or (not node.left and not node.right):
            return
        self.res.append(node.val)
        if node.left:
            self.findleftmost(node.left)
        else:
            self.findleftmost(node.right)
            
    def findrightmost(self, node):
        if not node or (not node.left and not node.right):
            return
        self.rig.append(node.val)
        if node.right:
            self.findrightmost(node.right)
        else:
            self.findrightmost(node.left)
            
    def findleaf(self, node):
        if not node:
            return
        if not node.left and not node.right:
            self.le.append(node.val)
            return 
        if node.left:
            self.findleaf(node.left)
        if node.right:
            self.findleaf(node.right)