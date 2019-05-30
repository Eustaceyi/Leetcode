# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def mergeTwoLists(self, l1: ListNode, l2: ListNode) -> ListNode:
        if not l1 and not l2:
            return
        elif not l1:
            return l2
        elif not l2:
            return l1
        flag = 0
        dummyhead = ListNode(0)
        curr = dummyhead
        while l1 and l2:
            if l1.val > l2.val:
                curr.next = ListNode(l2.val)
                curr = curr.next
                l2 = l2.next
                flag = 0
            else:
                curr.next = ListNode(l1.val)
                curr = curr.next
                l1 = l1.next
                flag = 1
        if flag == 0:
            curr.next = l1
        else:
            curr.next = l2
        return dummyhead.next