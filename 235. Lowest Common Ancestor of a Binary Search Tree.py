# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        pathp = [root]
        node = root
        while node is not p:
            if p.val < node.val:
                node = node.left
                pathp.append(node)
            else:
                node = node.right
                pathp.append(node)
        
        prev, node = root, root
        while node in pathp and q is not node:
            if q.val < node.val:
                prev = node
                node = node.left
            else:
                prev = node
                node = node.right
        if node not in pathp:
            return prev
        else:
            return q
            

def lowestCommonAncestor(self, root, p, q):
    if p.val < root.val > q.val:
        return self.lowestCommonAncestor(root.left, p, q)
    if p.val > root.val < q.val:
        return self.lowestCommonAncestor(root.right, p, q)
    return root

def lowestCommonAncestor(self, root, p, q):
    while (root.val - p.val) * (root.val - q.val) > 0:
        root = (root.left, root.right)[p.val > root.val]
    return root