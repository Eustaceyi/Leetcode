# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def reorderList(self, head: ListNode) -> None:
        """
        Do not return anything, modify head in-place instead.
        """
        if not head or not head.next:
            return
        # find the mid point
        slow = fast = head
        while fast and fast.next:
            fast = fast.next.next
            slow = slow.next
        # reverse the second part
        curr = slow
        prev = None
        while curr:
            temp = curr.next
            curr.next = prev
            prev = curr
            curr = temp
        # relink nodes
        node = head
        while prev.next and node.next:
            temp = node.next
            node.next = prev
            revtemp = prev.next
            prev.next = temp
            node = temp
            prev = revtemp