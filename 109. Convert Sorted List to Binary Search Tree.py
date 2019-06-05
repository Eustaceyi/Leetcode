# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def sortedListToBST(self, head: ListNode) -> TreeNode:
        if not head:
            return head
        ls = []
        while head:
            ls.append(head.val)
            head = head.next
        return self.helper(ls, 0, len(ls)-1)
        
    def helper(self, nums, lo, hi):
        if lo > hi or lo < 0 or hi > len(nums)-1:
            return 
        elif lo == hi:
            return TreeNode(nums[lo])
        else:
            mid = (hi - lo) // 2 + lo
            node = TreeNode(nums[mid])
            node.left = self.helper(nums, lo, mid-1)
            node.right = self.helper(nums, mid+1, hi)
        return node
            