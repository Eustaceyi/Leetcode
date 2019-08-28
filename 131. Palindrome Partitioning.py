class Solution:
    '''
    DFS solution, time O(2^n * n)
    '''
    def partition(self, s: str) -> List[List[str]]:
        results = []
        self.dfs(s, [], results)
        return results
        
    def dfs(self, s, result, results):
        if not s:
            results.append(result)
            return
        for i in range(len(s)):
            if self.isPal(s[:i+1]):
                self.dfs(s[i+1:], result+[s[:i+1]], results)
        
    def isPal(self, s):
        return s == s[::-1]