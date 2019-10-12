# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def numComponents(self, head: ListNode, G: List[int]) -> int:
        setG = set(G)
        res = 0
        node = head
        while node:
            if node.val in setG and (not node.next or node.next.val not in setG):
                res += 1
            node = node.next
        return res