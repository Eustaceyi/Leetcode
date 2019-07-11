class Solution:
    '''
    recursion method
    '''
    def numDecodings(self, s: str) -> int:
        mem = {}
        return self.helper(s, mem)
        
    def helper(self, s, mem):
        if s in mem:
            return mem[s]
        
        if not s:
            return 1
        if len(s) == 1:
            if s[0] == '0':
                return 0
            else:
                return 1
        res = 0
        if int(s[-1]) > 0:
            if 9 < int(s[-2:]) < 27:
                res = self.helper(s[:-1], mem) + self.helper(s[:-2], mem)
            else:
                res = self.helper(s[:-1], mem)
        elif 9 < int(s[-2:]) < 27:
            res =  self.helper(s[:-2], mem)
        mem[s] = res
        return res

class Solution:
    '''
    dp solution
    '''
    def numDecodings(self, s: str) -> int:  
        if len(s) == 0:
            return 1
 
        dp = [0 for i in range(len(s)+1)]
        dp[0] = 1
        dp[1] = 0 if s[0] == '0' else 1 
        for i in range(2,len(s)+1):
            if s[i-1] != '0':
                dp[i] = dp[i-1]
                if 9 < int(s[i-2:i]) < 27:
                    dp[i] += dp[i-2]
            elif 9 < int(s[i-2:i]) < 27:
                dp[i] = dp[i-2]
            else:
                dp[i] = 0
        return dp[len(s)]