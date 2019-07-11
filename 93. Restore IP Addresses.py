class Solution:
    '''
    My solution using dfs
    '''
    def restoreIpAddresses(self, s: str) -> List[str]:
        if len(s) < 4 or len(s) > 12:
            return []
        results = []
        self.helper(s, 4, [], results)
        return results
        
    def helper(self, s, n, result, results):
        if len(s) < n or len(s) > 3*n:
            return
        if not n:
            results.append('.'.join(result))
            return
        if s[0] == '0':
            self.helper(s[1:], n-1, result+[s[0]], results)
        else:
            if len(s) >= 1:
                self.helper(s[1:], n-1, result+[s[0]], results)
            if len(s) >= 2:
                self.helper(s[2:], n-1, result+[s[:2]], results)
            if len(s) >= 3 and int(s[:3]) < 256:
                self.helper(s[3:], n-1, result+[s[:3]], results)