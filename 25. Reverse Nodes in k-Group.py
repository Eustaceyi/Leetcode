# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def reverseKGroup(self, head: ListNode, k: int) -> ListNode:
        dummy = ListNode(0)
        dummy.next = head
        fast, slow = head, head
        prev_k = dummy
        while True:
            count = 0
            while fast and count < k:
                fast = fast.next
                count += 1
            if count == k:
                pre, cur = fast, slow
                for _ in range(k):
                    cur.next, cur, pre = pre, cur.next, cur 
                prev_k.next, prev_k, slow = pre, slow, fast
            else:
                return dummy.next