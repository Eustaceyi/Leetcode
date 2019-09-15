class Solution:
    def decodeString(self, s: str) -> str:
        idx = 0
        result = ''
        while idx < len(s):
            if s[idx].isdigit():
                mul = ''
                while s[idx].isdigit():
                    mul += s[idx]
                    idx += 1
                mul = int(mul)
                end = self.find(s[idx:], idx)
                result += self.build(s[idx+1:end], mul)
                idx = end + 1
            else:
                result += s[idx]
                idx += 1
        return result
        
    def find(self, s, idx):
        count = 0
        for i, char in enumerate(s, idx):
            if char == ']':
                count -= 1
            elif char == '[':
                count += 1
            if count == 0:
                return i
            
    def build(self, s, mul):
        idx = 0
        result = ''
        while idx < len(s):
            if s[idx].isdigit():
                mul_in = ''
                while s[idx].isdigit():
                    mul_in += s[idx]
                    idx += 1
                mul_in = int(mul_in)
                end = self.find(s[idx:], idx)
                result += self.build(s[idx+1:end], mul_in)
                idx = end + 1
            else:
                result += s[idx]
                idx += 1
        return mul*result