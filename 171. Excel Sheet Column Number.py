class Solution:
    def titleToNumber(self, s: str) -> int:
        output = 0
        for char in s:
            output = output * 26 + ord(char) - ord('A') + 1
        return output