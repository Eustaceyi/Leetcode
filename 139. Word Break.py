class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        '''
        dp solution, O(n^2) time O(n) space
        '''
        dp = [False for i in range(len(s)+1)]
        dp[0] = True
        for i in range(len(s)):
            if dp[i]:
                for j in range(i+1,len(s)+1):
                    if s[i:j] in wordDict:
                        dp[j] = True
        return dp[-1]

class Solution:
    '''
    recursion soluiton with memo, O(n^2) recursion tree time, O(n) recursion depth space
    '''
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        self.memo = {}
        return self.dfs(s, wordDict)
        
    def dfs(self, s, wordDict):
        if not s:
            return True
        if s in self.memo:
            return self.memo[s]
        for word in wordDict:
            if s[:len(word)] in wordDict and self.dfs(s[len(word):], wordDict):
                self.memo[s] = True
                return True
        self.memo[s] = False
        return False