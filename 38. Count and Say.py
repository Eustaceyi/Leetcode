class Solution:
    def countAndSay(self, n: int) -> str:
        '''
        need a helper and just start from beginning and go through to the end
        '''
        res = '1'
        for i in range(n-1):
            res = self.next(res)
        return res
        
    def next(self, s):
        res = ''
        count = 0
        for i, char in enumerate(s):
            if i == 0:
                count += 1
            elif char == s[i-1]:
                count += 1
            else:
                res += str(count)
                res += str(s[i-1])
                count = 1
        res += str(count)
        res += str(s[-1])
        return res