# The guess API is already defined for you.
# @param num, your guess
# @return -1 if my number is lower, 1 if my number is higher, otherwise return 0
# def guess(num):

class Solution(object):
    def guessNumber(self, n):
        """
        :type n: int
        :rtype: int
        """
        lo = 1
        hi = n
        while lo <= hi:
            mid = (hi-lo)//2+lo
            print(guess(mid))
            if not guess(mid):
                return mid
            elif guess(mid) == -1:
                hi = mid-1
            else:
                lo = mid+1