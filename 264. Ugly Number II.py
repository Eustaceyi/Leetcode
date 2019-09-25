class Solution:
    def nthUglyNumber(self, n: int) -> int:
        p2 = 0
        p3 = 0
        p5 = 0
        result = [1]
        while len(result) < n:
            n2 = result[p2]*2
            n3 = result[p3]*3
            n5 = result[p5]*5
            n_ = min(n2, n3, n5)
            if n2 == n_:
                p2 += 1
            if n3 == n_:
                p3 += 1
            if n5 == n_:
                p5 += 1
            result.append(n_)
        return result[-1]