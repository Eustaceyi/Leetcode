class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        '''
        dp solution, bottom up
        '''
        dp = [-1] * (amount+1)
        dp[0] = 0
        for i in range(1, amount+1):
            temp = []
            for coin in coins:
                if 0 <= i-coin and dp[i-coin] != -1:
                    temp.append(dp[i-coin]+1)
            dp[i] = min(temp) if temp else -1
        return dp[-1]