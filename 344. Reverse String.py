class Solution:
    def reverseString(self, s: List[str]) -> None:
        """
        Do not return anything, modify s in-place instead.
        """
        hl, l = len(s)//2, len(s)
        for i in range(hl):
            s[i], s[l-1-i] = s[l-1-i], s[i]