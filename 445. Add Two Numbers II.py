# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def addTwoNumbers(self, l1: ListNode, l2: ListNode) -> ListNode:
        '''
        Reverse two list and add and reverse back
        '''
        l1 = self.reverse(l1)
        l2 = self.reverse(l2)
        
        if not l1 and not l2:
            return
        carry = 0
        dmhead = curr = ListNode(0)
        while l1 and l2:
            carry, value = divmod(l1.val+l2.val+carry, 10)
            curr.next = ListNode(value)
            curr = curr.next
            l1 = l1.next
            l2 = l2.next
        while l1:
            carry, value = divmod(l1.val+carry, 10)
            curr.next = ListNode(value)
            curr = curr.next
            l1 = l1.next
        while l2:
            carry, value = divmod(l2.val+carry, 10)
            curr.next = ListNode(value)
            curr = curr.next
            l2 = l2.next
        if carry:
            curr.next = ListNode(1)
        return self.reverse(dmhead.next)
        
    def reverse(self, head):
        if not head or not head.next:
            return head
        prev = head
        curr = head.next
        prev.next = None
        while curr:
            temp = curr.next
            curr.next = prev
            prev = curr
            curr = temp
        return prev

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def addTwoNumbers(self, l1: ListNode, l2: ListNode) -> ListNode:
        '''
        To int and add
        '''
        intl1 = self.lltoint(l1)
        intl2 = self.lltoint(l2)
        result = intl1 + intl2
        dmhead = ListNode(0)
        if result == 0:
            return dmhead
        while result:
            result, value = divmod(result, 10)
            temp = dmhead.next
            dmhead.next = ListNode(value)
            dmhead.next.next = temp
        return dmhead.next
        
    def lltoint(self, head):
        if not head:
            return 0
        result = 0
        while head:
            result = result * 10 + head.val
            head = head.next
        return result