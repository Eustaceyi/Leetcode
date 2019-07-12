# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def zigzagLevelOrder(self, root: TreeNode) -> List[List[int]]:
        if not root:
            return []
        queue, temp, res, rev = [root], [], [], True
        while queue:
            r = []
            for node in queue:
                r.append(node.val)
                if node.left:
                    temp.append(node.left) 
                if node.right:
                    temp.append(node.right)
            
            res.append(r if rev else r[::-1])
            rev = not rev
            queue = temp
            temp = []
        return res