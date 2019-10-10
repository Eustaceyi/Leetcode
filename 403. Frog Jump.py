class Solution:
    def canCross(self, stones: List[int]) -> bool:
        '''
        DP solution,
        Time O(n^2)
        Space O(n^2)
        '''
        dp = {}
        for i in stones:
            dp[i] = set()
        dp[0].add(0)
        for i in stones:
            for step in dp[i]:
                if step+i in dp:
                    dp[step+i].add(step)
                if step != 1 and step+i-1 in dp:
                    dp[step+i-1].add(step-1)
                if step+i+1 in dp:
                    dp[step+i+1].add(step+1)
        return len(dp[stones[-1]]) > 0