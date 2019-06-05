# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def removeElements(self, head: ListNode, val: int) -> ListNode:
        if not head:
            return head
        dm = ListNode(val-1)
        dm.next = head
        prev = dm
        while head:
            if head.val == val:
                prev.next = head.next
            else:
                prev = head
            head = head.next
        return dm.next