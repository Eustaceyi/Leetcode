# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def delNodes(self, root: TreeNode, to_delete: List[int]) -> List[TreeNode]:
        '''
        O(n) method with dic recording parent, space O(n)
        '''
        to_delete = set(to_delete)
        self.res = set()
        self.res.add(root)
        self.par = {}
        self.par[root] = (None, None)
        self.helper(root, to_delete)
        return self.res
        
    def helper(self, node, to_delete):
        if not node or not to_delete:
            return
        if node.left:
            self.par[node.left] = (node, 0)
        if node.right:
            self.par[node.right] = (node, 1)
            
        if node.val not in to_delete:
            self.helper(node.left, to_delete)
            self.helper(node.right, to_delete)
        else:
            if self.par[node][1] == 0:
                self.par[node][0].left = None
            elif self.par[node][1] == 1:
                self.par[node][0].right = None
            
            l = node.left
            r = node.right
            node.left = None
            node.right = None
            to_delete.remove(node.val)
            if node in self.res:
                self.res.remove(node)
            if l:
                self.res.add(l)
                self.helper(l, to_delete)
            if r:
                self.res.add(r)
                self.helper(r, to_delete)

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def delNodes(self, root: TreeNode, to_delete: List[int]) -> List[TreeNode]:
        '''
        A less memory use method, also O(n) time
        Point is using return value to keep track of parents and children
        '''
        self.to_delete = set(to_delete)
        self.res = set()
        self.helper(root, False)
        return self.res
        
    def helper(self, node, par_exist):
        if not node:
            return None
        if node.val in self.to_delete:
            node.left = self.helper(node.left, False)
            node.right = self.helper(node.right, False)
            return None
        else:
            if not par_exist:
                self.res.add(node)
            node.left = self.helper(node.left, True)
            node.right = self.helper(node.right, True)
            return node