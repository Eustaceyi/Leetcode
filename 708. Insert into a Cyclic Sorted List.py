"""
# Definition for a Node.
class Node:
    def __init__(self, val, next):
        self.val = val
        self.next = next
"""
class Solution:
    def insert(self, head: 'Node', insertVal: int) -> 'Node':
        if not head:
            head = Node(insertVal, None)
            head.next = head
            return head
        else:
            end = prev = head
            start = node = head.next
            while 1:
                if node.val < prev.val:
                    start = node
                    end = prev
                    break
                node = node.next
                prev = prev.next
                if node == head.next:
                    break
            if insertVal <= start.val or insertVal >= end.val:
                temp = Node(insertVal, start)
                end.next = temp
                return head
            curr = start
            prev = end
            while curr.val < insertVal:
                prev = curr
                curr = curr.next
            temp = Node(insertVal, curr)
            prev.next = temp
            return head