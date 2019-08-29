# Definition for a binary tree node.
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution:
    '''
    recrusion method
    '''
    def preorderTraversal(self, root: TreeNode) -> List[int]:
        l = []
        self.helper(root, l)
        return l
        
    def helper(self, root, lis):
        if not root:
            return
        lis.append(root.val)
        self.helper(root.left, lis)
        self.helper(root.right, lis)

class Solution:
    def preorderTraversal(self, root: TreeNode) -> List[int]:
        '''
        iterative method
        '''
        if not root:
            return []
        stack = [root]
        output = []
        while stack:
            node = stack.pop(-1)
            if node:
                output.append(node.val)
            if node.right:
                stack.append(node.right)
            if node.left:
                stack.append(node.left)
        return output