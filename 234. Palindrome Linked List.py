# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def isPalindrome(self, head: ListNode) -> bool:
        '''
        O(n) time & space
        '''
        if not head or not head.next:
            return True
        ls = []
        while head:
            ls.append(head.val)
            head = head.next
        return ls == ls[::-1]

class Solution:
    def isPalindrome(self, head: ListNode) -> bool:
        '''
        O(n) time and O(1) space
        '''
        if not head or not head.next:
            return True
        rev = None
        slow = fast = head
        while fast and fast.next:
            fast = fast.next.next
            temp = rev
            rev = slow
            slow = slow.next
            rev.next = temp
        if fast:
            slow = slow.next
        while rev and rev.val == slow.val:
            slow = slow.next
            rev = rev.next
        return not rev