# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def isSameTree(self, p: TreeNode, q: TreeNode) -> bool:
        '''
        recursion method
        '''
        if not p and not q:
            return True
        if not p or not q:
            return False
        if q.val != p.val:
                return False
        return self.isSameTree(p.left, q.left) and self.isSameTree(p.right, q.right)

    def isSameTree2(self, p, q):
        '''
        itertive method using stack
        '''
        stack = [(p, q)]
        while stack:
            node1, node2 = stack.pop()
            if not node1 and not node2:
                continue
            elif None in [node1, node2]:
                return False
            else:
                if node1.val != node2.val:
                    return False
                stack.append((node1.right, node2.right))
                stack.append((node1.left, node2.left))
        return True