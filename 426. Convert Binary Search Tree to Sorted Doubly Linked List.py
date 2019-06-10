"""
# Definition for a Node.
class Node:
    def __init__(self, val, left, right):
        self.val = val
        self.left = left
        self.right = right
"""
class Solution:
    def treeToDoublyList(self, root: 'Node') -> 'Node':
        if not root:
            return root
        dmhead = node = Node(0, None, None)
        ls = []
        self.inorder(root, ls)
        for item in ls:
            node.right = Node(item, node, None)
            node = node.right
        dmhead.right.left = node
        node.right = dmhead.right
        return dmhead.right
        
    def inorder(self, root, ls):
        if not root:
            return
        self.inorder(root.left, ls)
        ls.append(root.val)
        self.inorder(root.right, ls)

"""
# Definition for a Node.
class Node:
    def __init__(self, val, left, right):
        self.val = val
        self.left = left
        self.right = right
"""
class Solution:
    def treeToDoublyList(self, root: 'Node') -> 'Node':
        def inorder(root):
            nonlocal start, end
            if root:
                inorder(root.left)
                if end:
                    end.right = root
                    root.left = end
                else:
                    start = root
                end = root
                inorder(root.right)
        if not root:
            return
        start, end = None, None
        inorder(root)
        start.left = end
        end.right = start
        return start