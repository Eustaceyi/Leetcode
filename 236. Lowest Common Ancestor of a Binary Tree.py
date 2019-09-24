# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        '''
        Solution easy to follow
        '''
        self.ans = None
        self.trav_tree(root, p, q)
        return self.ans
        
        
    def trav_tree(self, root, p, q):
        if not root:
            return False
        left = self.trav_tree(root.left, p, q)
        right = self.trav_tree(root.right, p, q)
        mid = root == p or root == q
        if left+right+mid >=2:
            self.ans = root
        return left or right or mid

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        '''
        more concise one
        '''
        if not root or root in [p, q]:
            return root
        left = self.lowestCommonAncestor(root.left, p, q)
        right = self.lowestCommonAncestor(root.right, p, q)
        if not left:
            return right
        elif not right:
            return left
        else:
            return root