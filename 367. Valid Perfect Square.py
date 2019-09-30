class Solution:
    def isPerfectSquare(self, num: int) -> bool:
        lo = 1
        hi = num
        while lo <= hi:
            mid = (hi-lo)//2+lo
            if mid**2 == num:
                return True
            elif mid**2 < num:
                lo = mid+1
            else:
                hi = mid-1
        return False

    def NewtonMethod(self, num):
        r = num
        while r*r > num:
            r = (r + num/r) // 2
        return r*r == num

    def Math(self, num):
        i = 1
        while (num>0):
            num -= i
            i += 2       
        return num == 0