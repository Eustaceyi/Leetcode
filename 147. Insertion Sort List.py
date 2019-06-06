# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def insertionSortList(self, head: ListNode) -> ListNode:
        if not head or not head.next:
            return head
        node = dummy = ListNode(0)
        dummy.next = curr = head
        while curr.next:
            v = curr.next.val
            if v >= curr.val:
                curr = curr.next
                continue
            if v < node.next.val:
                node = dummy
            while v >= node.next.val:
                node = node.next
            tomove = curr.next
            curr.next = tomove.next
            tomove.next = node.next
            node.next = tomove
        return dummy.next