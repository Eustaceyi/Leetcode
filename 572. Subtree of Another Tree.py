# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def isSubtree(self, s: TreeNode, t: TreeNode) -> bool:
        '''
        Recursive method, comparing with all node of s
        Time O(M*N)
        Space O(M) since we use level order traversal
        '''
        if not s and not t:
            return True
        elif not s:
            return False
        elif not t:
            return False
        queue = [s]
        while queue:
            temp = []
            for node in queue:
                res = self.check(node, t)
                if res:
                    return True
                if node.left:
                    temp.append(node.left)
                if node.right:
                    temp.append(node.right)
            queue = temp
        return False
            
            
    def check(self, node1, node2):
        if not node1 and not node2:
            return True
        elif not node1 or not node2:
            return False
        if node1.val != node2.val:
            return False
        return self.check(node1.left, node2.left) and self.check(node1.right, node2.right)