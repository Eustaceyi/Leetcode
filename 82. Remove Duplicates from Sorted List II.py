# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def deleteDuplicates(self, head: ListNode) -> ListNode:
        if not head or not head.next:
            return head
        dummyhead = ListNode(head.val-1)
        dummyhead.next = head
        prev = dummyhead
        while head and head.next:
            if  head.val == head.next.val:
                while head.next and head.val == head.next.val:
                    head.next = head.next.next
                prev.next = head.next
                head = prev.next
            else:
                prev = head
                head = head.next
        return dummyhead.next