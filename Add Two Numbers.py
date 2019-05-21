# Definition for singly-linked list.
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution:
    def addTwoNumbers(self, l1, l2):
        flag = 0
        dummyhead = ListNode(0)
        curr = dummyhead
        while flag == 1 or l1 or l2:
            if l1 is None and l2 is None:
                curr.next = ListNode(1)
                flag = 0
            elif l1 and l2:
                curr.next = ListNode((l1.val + l2.val + flag) % 10)
                flag = (l1.val + l2.val + flag) // 10
                l1 = l1.next
                l2 = l2.next
                curr = curr.next
            elif not l1:
                curr.next = ListNode((l2.val + flag) % 10)
                flag = (l2.val + flag) // 10
                l2 = l2.next
                curr = curr.next
            elif not l2:
                curr.next = ListNode((l1.val + flag) % 10)
                flag = (l1.val + flag) // 10
                l1 = l1.next
                curr = curr.next
        return dummyhead.next
