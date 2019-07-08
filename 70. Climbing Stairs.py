class Solution:
    def climbStairs(self, n: int) -> int:
        result = [1,2]
        for i in range(2,n):
            result.append(result[i-1]+result[i-2])
        return result[n-1]

class Solution:
    def climbStairs(self, n: int) -> int:
        if n == 1 or n == 2:
            return n
        a, b = 1, 2
        for _ in range(2,n):
            c = a + b
            a = b
            b = c
        return c