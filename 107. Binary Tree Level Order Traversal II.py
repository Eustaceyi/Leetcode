# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def levelOrderBottom(self, root: TreeNode) -> List[List[int]]:
        if not root:
            return []
        queue, temp, res = [root], [], []
        while queue:
            r = []
            for node in queue:
                r.append(node.val)
                if node.left:
                    temp.append(node.left) 
                if node.right:
                    temp.append(node.right)
            res.append(r)
            queue = temp
            temp = []
        return res[::-1]