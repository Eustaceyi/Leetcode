# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    '''
    naive recursion
    '''
    def isValidBST(self, root: TreeNode) -> bool:
        if not root or (not root.left and not root.right):
            return True
        l = root.left
        while l and l.right:
            l = l.right
        r = root.right
        while r and r.left:
            r = r.left
        if (l and l.val >= root.val) or (r and r.val <= root.val):
            return False
        return self.isValidBST(root.left) and self.isValidBST(root.right)

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    '''
    recursion with a helper method
    '''
    def isValidBST(self, root: TreeNode) -> bool:
        return self.helper(root, float('-inf'), float('inf'))
        
    def helper(self, root, lb, ub):
        if not root:
            return True
        val = root.val
        if val <= lb or val >= ub:
            return False
        return self.helper(root.left, lb, val) and self.helper(root.right, val, ub)

class Solution:
    '''
    inorder traversal and check if the previous one is smaller than the next one
    '''
    def isValidBST(self, root):
        stack, inorder = [], float('-inf')
        
        while stack or root:
            while root:
                stack.append(root)
                root = root.left
            root = stack.pop()
            # If next element in inorder traversal
            # is smaller than the previous one
            # that's not BST.
            if root.val <= inorder:
                return False
            inorder = root.val
            root = root.right

        return True