# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def plusOne(self, head: ListNode) -> ListNode:
        '''
        The reverse add reverse method, O(n) and O(1) time and memory
        '''
        if not head.next:
            if head.val != 9:
                head.val += 1
                return head
            else:
                head.val = 1
                head.next = ListNode(0)
                return head
        prev = head
        node = head.next
        prev.next = None
        while node:
            temp = node.next
            node.next = prev
            prev = node
            if not temp:
                break
            node = temp
        head = node
        carry = (node.val + 1)//10
        if not carry:
            node.val += 1
        prev = None
        while node and carry:
            prev = node
            carry, node.val = (node.val + 1)//10, (node.val + 1)%10
            node = node.next
        if carry:
            prev.next = ListNode(1)
        prev = head
        node = head.next
        prev.next = None
        while node:
            temp = node.next
            node.next = prev
            prev = node
            if not temp:
                break
            node = temp
        return node

    def plusOne(self, head: ListNode) -> ListNode:
        '''
        The recursion method O(n) and O(n)
        '''
        carry = self.addone(head)
        if carry:
            newhead = ListNode(1)
            newhead.next = head
            return newhead
        return head
        
    def addone(self, head):
        if not head:
            return 1
        else:
            carry, head.val = divmod(head.val+self.addone(head.next), 10)
            return carry