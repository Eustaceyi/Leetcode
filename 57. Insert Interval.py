class Solution:
    def insert(self, intervals: List[List[int]], newInterval: List[int]) -> List[List[int]]:
        if not newInterval:
            return intervals
        if not intervals:
            return [newInterval]
        left, right = [], []
        for i in intervals:
            if i[1] < newInterval[0]:
                left.append(i)
            elif i[0] > newInterval[1]:
                right.append(i)
            else:
                newInterval[0] = min(newInterval[0], i[0])
                newInterval[1] = max(newInterval[1], i[1])
        return left + [newInterval] + right