# Definition for a binary tree node.
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution:
    def postorderTraversal(self, root: TreeNode) -> List[int]:
        l = []
        self.helper(root, l)
        return l 
        
    def helper(self, root, list):
        if not root:
            return
        self.helper(root.left, list)
        self.helper(root.right, list)
        list.append(root.val)

class Solution:
    def postorderTraversal(self, root: TreeNode) -> List[int]:
        if not root:
            return []
        stack = [root]
        output = []
        while stack:
            node = stack.pop(-1)
            if node.left:
                stack.append(node.left)
            if node.right:
                stack.append(node.right)
            output.append(node.val)
        return output[::-1]