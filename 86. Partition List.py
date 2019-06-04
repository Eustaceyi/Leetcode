# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def partition(self, head: ListNode, x: int) -> ListNode:
        if not head or not head.next:
            return head
        lh = ListNode(0)
        gh = ListNode(0)
        lc = lh
        gc = gh
        while head:
            if head.val < x:
                lc.next = head
                lc = lc.next
            else:
                gc.next = head
                gc = gc.next
            head = head.next
        gc.next = None
        lc.next = gh.next
        return lh.next