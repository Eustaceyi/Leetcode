class Solution:
    def longestPalindromeSubseq(self, s: str) -> int:
        '''
        First we initialize a l x l matrix, 
        for each entry dp[i][j] means the longest subseq from i to j (both inclusive) that is palindrome
        and we fill the diag with 1,
        then we process other area:
        1. if s[i] == s[j] which means that we can get two more length than dp[i+1][j-1]
        2. if s[i] != s[j] which means that we should pick the longer one of dp[i+1][j] or dp[i][j-1]
        finally we get the solution on dp[0][l-1]
        '''
        if not s:
            return 0
        # preprocess the palindrome string to avoid TLE
        if s == s[::-1]:
            return len(s)
        l = len(s)
        dp = [[0 for _ in range(l)] for _ in range(l)]
        for i in range(l-1, -1, -1):
            dp[i][i] = 1
            for j in range(i+1, l):
                if s[i] == s[j]:
                    dp[i][j] = dp[i+1][j-1]+2
                else:
                    dp[i][j] = max(dp[i+1][j], dp[i][j-1])
        return dp[0][l-1]
                