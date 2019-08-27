# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None


class Solution:
    '''
    DFS with recursion
    '''
    def sumNumbers(self, root: TreeNode) -> int:
        self.results = 0
        self.dfs(root, 0)
        return self.results
        
    def dfs(self, root, value):
        if root:
            self.dfs(root.left, value*10+root.val)
            self.dfs(root.right, value*10+root.val)
            if not root.left and not root.right:
                self.results += value*10 + root.val

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    '''
    DFS with stack
    '''
    def sumNumbers(self, root: TreeNode) -> int:
        result = 0
        if root:
            stack = [(root, root.val)]
            while stack:
                node, val = stack.pop(-1)
                if node.left:
                    stack.append((node.left, val*10+node.left.val))
                if node.right:
                    stack.append((node.right, val*10+node.right.val))
                if not node.left and not node.right:
                    result += val
        return result

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    '''
    BFS with queue
    '''
    def sumNumbers(self, root: TreeNode) -> int:
        result = 0
        if root:
            queue = [(root, root.val)]
            while queue:
                node, val = queue.pop(0)
                if node.left:
                    queue.append((node.left, val*10+node.left.val))
                if node.right:
                    queue.append((node.right, val*10+node.right.val))
                if not node.right and not node.left:
                    result += val
        return result