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
        curr = dummy = Node(0, None, None, None)
        head = root
        
        while root:
            if root.left:
                curr.next = root.left
                curr = curr.next
            
            if root.right:
                curr.next = root.right
                curr = curr.next
            
            root = root.next
            
            if not root:
                curr = dummy
                root = dummy.next
                dummy.next = None
        
        return head