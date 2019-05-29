class Solution:
    def romanToInt(self, s: str) -> int:
        '''
        make a dict for look up, and then check some conditions for subtracting some number
        '''
        toret = 0
        dict = {
            'I' : 1,
            'V' : 5,
            'X' : 10,
            'L' : 50,
            'C' : 100,
            'D' : 500,
            'M' : 1000
        }
        for i, char in enumerate(s):
            toret += dict[char]
            if i != len(s) - 1:
                if char == 'C' and (s[i+1] == 'D' or s[i+1] == 'M'):
                    toret -= 200
                elif char == 'X' and (s[i+1] == 'L' or s[i+1] == 'C'):
                    toret -= 20
                elif char == 'I' and (s[i+1] == 'V' or s[i+1] == 'X'):
                    toret -= 2
        return toret