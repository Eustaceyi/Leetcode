class Solution:
    def reverse(self, x: int) -> int:
        '''
        Another way to do this is convert it to string and reverse it.
        This method uses mod and track the digits.
        '''
        sign = 1 if x > 0 else -1
        digits = []
        x *= sign
        while x != 0:
            digits.append(x%10)
            x = x // 10
        des = 0
        for i in digits:
            des = des * 10 + i
        des *= sign
        if des < -2**31 or des > 2**31-1:
            return 0
        else:
            return des