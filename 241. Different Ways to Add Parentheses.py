class Solution:
    def __init__(self):
        self.memo = {}
    def diffWaysToCompute(self, input: str) -> List[int]:
        '''
        Devide and conquer with memo.
        Time (at least) O(3^n)
        '''
        if not input:
            return []
        if input.isdigit():
            return [int(input)]
        if input in self.memo:
            return self.memo[input]
        res = []
        for i, c in enumerate(input):
            if c in '+-*':
                p1, p2 = input[:i], input[i+1:]
                ret1 = self.diffWaysToCompute(p1)
                ret2 = self.diffWaysToCompute(p2)
                for m in ret1:
                    for n in ret2:
                        res.append(self.helper(m, n, c))
        self.memo[input] = res
        return res
    
    def helper(self, m, n, c):
        if c == '+':
            return m+n
        elif c == '-':
            return m-n
        else:
            return m*n