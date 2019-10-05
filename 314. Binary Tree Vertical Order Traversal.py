# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def verticalOrder(self, root: TreeNode) -> List[List[int]]:
        '''
        BFS travesal to find out which row it belong to
        Time O(n) since we traversal each node two times
        Space O(n) a queue and a dictionary for nodes
        '''
        dic = collections.defaultdict(list)
        mincol = 2**31-1
        maxcol = -2**31
        
        if not root:
            return []
        queue = [(root, 0)]
        while queue:
            node, col = queue.pop(0)
            dic[col].append(node)
            if node.left:
                queue.append((node.left, col-1))
            if node.right:
                queue.append((node.right, col+1))
            mincol = min(col, mincol)
            maxcol = max(col, maxcol)
        res = []
        for i in range(mincol, maxcol+1):
            res.append([node.val for node in dic[i]])
        return res
            