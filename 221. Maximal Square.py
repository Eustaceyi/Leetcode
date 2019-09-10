class Solution:
    def maximalSquare(self, matrix: List[List[str]]) -> int:
        '''
        dp solution, time O(mn), space O(mn), this can also be optimized to space O(m) by using only 1D array
        '''
        r = len(matrix)
        c = 0 if not r else len(matrix[0])
        dp = [[0 for _ in range(c+1)] for _ in range(r+1)]
        maxlen = 0
        for i in range(1, r+1):
            for j in range(1, c+1):
                if matrix[i-1][j-1] == '1':
                    dp[i][j] = min(dp[i-1][j-1], dp[i-1][j], dp[i][j-1]) + 1
                    maxlen = max(maxlen, dp[i][j])
        return maxlen**2