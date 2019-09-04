class Solution:
    # @param n, an integer
    # @return an integer
    def reverseBits(self, n):
        st = ''
        for i in range(32):
            div, mod = divmod(n, 2)
            st += str(mod)
            n = div
        ans = 0
        for i in range(32):
            ans = ans*2 + int(st[i])
        return ans