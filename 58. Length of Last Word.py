class Solution:
    def lengthOfLastWord(self, s: str) -> int:
        return 0 if len(s.rstrip(' ').split()) == 0 else len(s.rstrip(' ').split()[-1])