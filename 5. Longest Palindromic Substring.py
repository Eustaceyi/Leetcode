class Solution:
    def longestPalindrome(self, s: str) -> str:
        '''
        This is a O(n^2) time O(1) space solution,
        there is a O(n) time solution,
        but may be come back later. 
        '''
        if not s or len(s) < 1: return ''
        elif len(s) == 1: return s
        maxstr = ""
        for i in range(len(s)):
            ret = self.expand(s, i, i)
            if len(ret) > len(maxstr):
                maxstr = ret
            ret = self.expand(s, i, i+1)
            if len(ret) > len(maxstr):
                maxstr = ret
        return maxstr
        
    def expand(self, s, left, right):
        while (left >= 0 and right < len(s) and s[left] == s[right]):
            left -= 1
            right += 1
        return s[left+1:right]