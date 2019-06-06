"""
# Definition for a Node.
class Node:
    def __init__(self, val, next, random):
        self.val = val
        self.next = next
        self.random = random
"""
class Solution:
    def copyRandomList(self, head: 'Node') -> 'Node':
        '''
        hash table of original node to copy node
        if original node alreay has a copy, return copy
        so that we don't create it again.
        This only goes one pass.
        '''
        if not head:
            return head
        visited = {}
        while head:
            if len(visited) == 0:
                new_head = Node(head.val, None, None)
                visited[head] = new_head
            if head in visited:
                new_node = visited[head]
            else:
                new_node = Node(head.val, None, None)
                visited[head] = new_node
            if head.next:
                if head.next in visited:
                    new_node.next = visited[head.next]
                else:
                    new_node.next = Node(head.next.val, None, None)
                    visited[head.next] = new_node.next
            if head.random:
                if head.random in visited:
                    new_node.random = visited[head.random]
                else:
                    new_node.random = Node(head.random.val, None, None)
                    visited[head.random] = new_node.random
            head = head.next
        return new_head
            