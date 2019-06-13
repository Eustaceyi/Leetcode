"""
# Definition for a Node.
class Node:
    def __init__(self, val, prev, next, child):
        self.val = val
        self.prev = prev
        self.next = next
        self.child = child
"""
class Solution:
    def flatten(self, head: 'Node') -> 'Node':
        if not head or (not head.next and not head.child):
            return head
        head, _ = self.helper(head)
        return head
            
            
    def helper(self, node):
        head = node
        while node:
            if not node.child:
                if not node.next:
                    break
                else:
                    node = node.next
            else:
                if node.next:
                    saved = node.next
                    chead, ctail = self.helper(node.child)
                    node.next = chead
                    chead.prev = node
                    saved.prev = ctail
                    ctail.next = saved
                    node.child = None
                    node = saved
                else:
                    chead, ctail = self.helper(node.child)
                    node.next = chead
                    chead.prev = node
                    node.child = None
                    node = ctail
                    break
            
        return head, node