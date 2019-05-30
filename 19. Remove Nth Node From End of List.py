# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def removeNthFromEnd(self, head: ListNode, n: int) -> ListNode:
        header = head
        curr = head
        prev = None
        for i in range(n - 1):
            header = header.next
        while header.next is not None:
            header = header.next
            prev = curr
            curr = curr.next
        if prev is None:
            return head.next
        prev.next = curr.next
        return head