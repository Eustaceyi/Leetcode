class Solution(object):
    def isPowerOfTwo(self, n):
        if n == 0:
            return False
        while n % 2 == 0:
            n /= 2
        return n == 1

class Solution(object):
    def isPowerOfTwo(self, n):
        if n == 0:
            return False
        return n & (-n) == n

class Solution(object):
    def isPowerOfTwo(self, n):
        if n == 0:
            return False
        return n & (n - 1) == 0