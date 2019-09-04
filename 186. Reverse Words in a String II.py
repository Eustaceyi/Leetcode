class Solution:
    '''
    First reverse all char, then reverse word
    '''
    def reverseWords(self, s: List[str]) -> None:
        """
        Do not return anything, modify s in-place instead.
        """
        if not s:
            return
        sp = 0
        self.rev(0, len(s)-1, s)
        for i in range(len(s)):
            if s[i] == ' ':
                self.rev(sp, i-1, s)
                sp = i+1
        self.rev(sp, len(s)-1, s)
        
    def rev(self, st, en, s):
        for i in range((en-st+1)//2):
            s[st+i], s[en-i] = s[en-i], s[st+i]
        return