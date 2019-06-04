# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def swapPairs(self, head: ListNode) -> ListNode:
        if not head or not head.next:
            return head
        dummyhead = ListNode(0)
        dummyhead.next = head
        prev = dummyhead       
        while head and head.next:
            prev.next = head.next
            temp = head.next.next
            prev = head
            head.next.next = head
            head.next = temp
            head = head.next
        return dummyhead.next