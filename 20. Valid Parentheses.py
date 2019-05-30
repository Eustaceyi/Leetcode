class Solution:
    def isValid(self, s: str) -> bool:
        '''
        Use the thought of stack to store chars, if the new one match the last one in the stack, pop it.
        If there is remain in stack, false, else true.
        '''
        if not s: return True
        ls = []
        dic = {
            '(':')',
            ')':'(',
            '[':']',
            ']':'[',
            '{':'}',
            '}':'{'
        }
        for char in s:
            if len(ls) == 0 or dic[char] != ls[-1]:
                ls.append(char)
            else:
                ls.pop()
        return not ls