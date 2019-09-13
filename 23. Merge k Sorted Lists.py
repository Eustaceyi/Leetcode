# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def mergeKLists(self, lists: List[ListNode]) -> ListNode:
        '''
        Priority Queue/ Heap Queue O(kN), space O(k)
        also can be done with merge2lists or mergesort
        '''
        heap = []
        dmhead = point = ListNode(0)
        i = 0
        for l in lists:
            if l:
                heapq.heappush(heap, (l.val, i, l))
                i += 1
        while heap:
            val, _, node = heapq.heappop(heap)
            point.next = ListNode(val)
            point = point.next
            if node.next:
                node = node.next
                heapq.heappush(heap, (node.val, i, node))
                i += 1
        return dmhead.next