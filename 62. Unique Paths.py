import math
class Solution:
    def uniquePaths_math(self, m: int, n: int) -> int:
        a = 1
        for i in range(m+n-2):
            a *= (i+1)
        b = 1
        for i in range(n-1):
            b *= (i+1)
        for i in range(m-1):
            b *= (i+1)
        return a//b

    def uniquePaths_dp_n2_space(self, m: int, n: int) -> int:
        dp = [[1] * n for _ in range(m)]
        for i in range(1, m):
            for j in range(1, n):
                dp[i][j] = dp[i-1][j] + dp[i][j-1]
        return dp[-1][-1]

    def uniquePaths_dp_n_space(self, m: int, n: int) -> int:
        dp = [1 for _ in range(n)]
        for i in range(1, m):
            for j in range(1, n):
                dp[j] += dp[j-1]
        return dp[-1]

    def uniquePaths_using_import(self, m: int, n: int) -> int:
        return math.factorial(m+n-2)//math.factorial(m-1)//math.factorial(n-1)