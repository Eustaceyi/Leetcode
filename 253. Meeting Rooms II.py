class Solution:
    def minMeetingRooms(self, intervals: List[List[int]]) -> int:
        if not intervals:
            return 0
        intervals = sorted(intervals, key=lambda x :x[0])
        minheap = []
        num = 0
        for intv in intervals:
            if not minheap or minheap[0][0] > intv[0]:
                num += 1
                heapq.heappush(minheap, (intv[1], intv, num))
            else:
                _, _, num_ = heapq.heappop(minheap)
                heapq.heappush(minheap, (intv[1], intv, num_))
        return num