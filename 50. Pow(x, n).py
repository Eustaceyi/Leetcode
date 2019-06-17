class Solution:
    def myPow(self, x: float, n: int) -> float:
        if n == 0:
            return 1
        if n == 1:
            return x
        if n < 0:
            return 1/ self.myPow(x, -n)
        if n % 2:
            return x * self.myPow(x*x, n//2)
        return self.myPow(x*x, n//2)

class Solution:
    def myPow(self, x: float, n: int) -> float:
        '''
        iterative method
        '''
        if n < 0:
            x, n = 1/x, -n
        ans = 1
        cur = x
        while n > 0:
            if n % 2:
                ans *= cur
            cur *=cur
            n = n//2
        return ans