class Solution:
    def trailingZeroes(self, n: int) -> int:
        f = 5
        result = 0
        while f <= n:
            result += n//f
            f *= 5
        return result