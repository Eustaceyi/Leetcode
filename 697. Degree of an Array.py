class Solution:
    def findShortestSubArray(self, nums: List[int]) -> int:
        dic = collections.defaultdict(list)
        for i, n in enumerate(nums):
            dic[n].append(i)
        ls = sorted(dic.values(), key=len, reverse=True)
        deg = ls[0][-1] - ls[0][0] + 1
        for i in range(1,len(ls)):
            if len(ls[i]) < len(ls[i-1]):
                break
            deg = min(deg, ls[i][-1] - ls[i][0] + 1)
        return deg
        