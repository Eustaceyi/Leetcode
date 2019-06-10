# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def splitListToParts(self, root: ListNode, k: int) -> List[ListNode]:
        length = self.lengthofll(root)
        nodenum, addonenum = divmod(length, k)
        result = []
        addcount = 0
        prev = None
        for i in range(k):
            dmhead = ListNode(0)
            result.append(dmhead)
            dmhead.next = root
            for j in range(nodenum):
                prev = root
                root = root.next
            if addcount < addonenum:
                prev = root
                root = root.next
                addcount += 1
            if prev:
                prev.next = None
        return [i.next for i in result]
        
    def lengthofll(self, head):
        count = 0
        while head:
            count += 1
            head = head.next
        return count