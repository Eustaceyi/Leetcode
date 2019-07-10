class Solution:
    def grayCode(self, n: int) -> List[int]:
        res = [0]
        for i in range(n):
            res += [item + (1<<i) for item in res[::-1]]
        return res