# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def rotateRight(self, head: ListNode, k: int) -> ListNode:
        if head is None or head.next is None:
            return head
        if k == 0:
            return head
        else:
            temp = head
            count = 1
            while temp.next:
                temp = temp.next
                count += 1
            k = k % count
            if k == 0:
                return head
            curr = head
            prev = None
            for i in range(count - k):
                prev = curr
                curr = curr.next
            prev.next = None
            temp.next = head
            return curr