"""
# Definition for a Node.
class Node:
    def __init__(self, val, left, right, next):
        self.val = val
        self.left = left
        self.right = right
        self.next = next
"""
class Solution:
    def connect(self, root: 'Node') -> 'Node':
        '''
        Naive level order traversal and connect, waste time and space
        '''
        if not root:
            return root
        queue = [root]
        while queue:
            temp = []
            for i in range(len(queue)):
                temp.append(queue[i].left)
                temp.append(queue[i].right)
                if i < len(queue)-1:
                    queue[i].next = queue[i+1]
                else:
                    queue[i].next = None
            if temp[0]:
                queue = temp
            else:
                return root

class Solution:
    def connect(self, root: 'Node') -> 'Node':
        '''
        O(1) space
        '''
        self.helper(root)
        return root
        
    def helper(self, root):
        if root and root.left:
            root.left.next = root.right
            if root.next:
                root.right.next = root.next.left
            self.helper(root.left)
            self.helper(root.right)