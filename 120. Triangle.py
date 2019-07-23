class Solution:
    def minimumTotal(self, triangle: List[List[int]]) -> int:
        '''
        Modify original
        '''
        if not triangle:
            return 0
        for i in range(1, len(triangle)):
            for j in range(1,i):
                triangle[i][j] += min(triangle[i-1][j], triangle[i-1][j-1])
            triangle[i][0] += triangle[i-1][0]
            triangle[i][-1] += triangle[i-1][-1]
        return min(triangle[-1])

class Solution:
    def minimumTotal(self, triangle: List[List[int]]) -> int:
        '''
        O(n) extra space
        '''
        if not triangle:
            return 0
        res = list(triangle[-1])
        for i in range(len(triangle)-2, -1, -1):
            for j in range(i+1):
                res[j] = min(res[j], res[j+1]) + triangle[i][j]
        return res[0]