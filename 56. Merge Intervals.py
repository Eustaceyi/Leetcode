class Solution:
    def merge(self, intervals: List[List[int]]) -> List[List[int]]:
        if not intervals:
            return []
        if len(intervals) == 1:
            return intervals
        result = []
        for i in sorted(intervals, key=lambda x:x[0]):
            if result and i[0] <= result[-1][1]:
                if i[1] >= result[-1][1]:
                    result[-1][1] = i[1]
            else:
                result.append(i)
        return result