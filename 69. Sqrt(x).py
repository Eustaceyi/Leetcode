class Solution:
    def mySqrt(self, x: int) -> int:
        '''
        Binary Search
        '''
        if x == 0:
            return 0
        if x == 1:
            return 1
        l, r = 0, x//2+1 
        while l < r:
            mid = (r-l)//2 + l
            if mid*mid == x:
                return mid
            elif mid*mid > x:
                r = mid
            else:
                l = mid+1
        return l-1

class Solution:
    def mySqrt(self, x: int) -> int:
        '''
        Newton's Method
        '''
        r = x
        while r*r > x:
            r = (r + x//r) // 2
        return r