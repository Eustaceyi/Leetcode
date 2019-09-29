# The isBadVersion API is already defined for you.
# @param version, an integer
# @return a bool
# def isBadVersion(version):

class Solution:
    def firstBadVersion(self, n):
        """
        :type n: int
        :rtype: int
        """
        lo = 1
        hi = n+1
        while lo < hi:
            mid = (hi-lo)//2+lo
            if not isBadVersion(mid):
                lo = mid + 1
            else:
                hi = mid
        return lo
        