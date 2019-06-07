# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def sortList(self, head: ListNode) -> ListNode:
        if not head or not head.next:
            return head
        slow = fast = head
        prev = None
        while fast and fast.next:
            prev = slow
            fast = fast.next.next
            slow = slow.next
        prev.next = None
        left = self.sortList(head)
        right = self.sortList(slow)
        head = self.merge(left, right)
        return head
    
    def merge(self, left, right):
        isLeft = 0
        if left.val < right.val:
            head = curr = left
            left = left.next
            isLeft = 1
        else:
            head = curr = right
            right = right.next
        while left and right:
            if left.val < right.val:
                curr.next = left
                left = left.next
                curr = curr.next
                isLeft = 1
            else:
                curr.next = right
                right = right.next
                curr = curr.next
                isLeft = 0
        if isLeft == 0:
            curr.next = left
        else:
            curr.next = right
        return head