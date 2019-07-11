class Solution:
    '''
    recursion method
    https://leetcode.com/articles/unique-binary-search-trees/
    '''
    def numTrees(self, n: int) -> int:
        memo = {}
        memo[0] = 1
        memo[1] = 1
        return self.helper(n, memo)
        
    def helper(self, n, memo):
        if n in memo:
            return memo[n]
        if n < 0:
            return 1
        res = 0
        for i in range(1, n+1):
            res += self.helper(i-1, memo) * self.helper(n-i, memo)
        memo[n] = res
        return res

class Solution:
    '''
    dp method
    '''
    def numTrees(self, n: int) -> int:
        G = [0 for i in range(n+1)]
        G[0], G[1] = 1, 1
        for i in range(2, n+1):
            for j in range(1, i+1):
                G[i] += G[j-1] * G[i-j]
        return G[n]

class Solution(object):
    '''
    math method
    '''
    def numTrees(self, n):
        C = 1
        for i in range(0, n):
            C = C * 2*(2*i+1)/(i+2)
        return int(C)