class Solution:
    def isHappy(self, n: int) -> bool:
        ls = []
        while n not in ls:
            ls.append(n)
            res = 0
            while n :
                n, mod = divmod(n, 10)
                res += mod**2
            if res == 1:
                return True
            n = res
        return False