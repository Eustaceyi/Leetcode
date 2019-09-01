class Solution:
    def convertToTitle(self, n: int) -> str:
        output = ''
        while n:
            n, res = divmod(n-1, 26)
            output = chr(ord('A') + res) + output
        return output