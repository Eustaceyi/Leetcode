class Solution:
    def divide(self, dividend: int, divisor: int) -> int:
        '''
        Consider a 32-bit machine.
        The only case to overflow is INT_MIN / -1
        and to prevent abs() overflow, we use negative numbers
        and the method is to find the closest 2^n*divisor and subtract that
        and we add n to result.
        '''
        if dividend == -2**31 and divisor == -1:
            return 2**31 -1
        sign = (dividend < 0) == (divisor < 0)
        if dividend > 0:
            dividend = 0 - dividend
        if divisor > 0:
            divisor = 0 - divisor
        res = 0
        while dividend <= divisor:
            temp = 1
            div = divisor
            while dividend <= div:
                div <<= 1
                temp <<= 1
            res += (temp>>1)
            dividend -= (div>>1)
        if sign:
            return res
        else:
            return 0 - res