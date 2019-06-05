# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def reverseBetween(self, head: ListNode, m: int, n: int) -> ListNode:
        if not head or not head.next or m == n:
            return head
        count = 1
        leftprev = None
        node = head
        while count < m:
            leftprev = node
            node = node.next
            count += 1
        prev = node
        curr = node.next
        prev.next = None
        while count < n:
            temp = curr.next
            curr.next = prev
            prev = curr
            curr = temp
            count += 1
        if leftprev:
            leftprev.next.next = curr
            leftprev.next = prev
        else:
            head.next = curr
            head = prev
        return head
        