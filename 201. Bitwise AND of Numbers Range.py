class Solution:
    def rangeBitwiseAnd(self, m: int, n: int) -> int:
        '''
        Now consider a range

        [m = 0bxyz0acd, n=0bxyz1rst]
        here xyzpacdrst all are digits in base 2.

        We can find two numbers that are special in the range [m, n]

        (1) m' = 0bxyz0111
        (2) n' = 0bxyz1000
        The bitwise AND of all the numbers in range [m, n] is just the bitwise AND of the two special number

        rangeBitwiseAnd(m, n) = m' & n' = 0bxyz0000
        This tells us, the bitwise and of the range is keeping the common bits of m and n from left to right 
        until the first bit that they are different, padding zeros for the rest.
        '''
        i = 0
        while m != n:
            m >>= 1
            n >>= 1
            i += 1
        return n << i