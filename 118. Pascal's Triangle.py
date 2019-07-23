class Solution:
    def generate(self, numRows: int) -> List[List[int]]:
        res = []
        for i in range(1, numRows+1):
            res.append(self.makelist(i))
        return res
        
    def fac(self, n):
        res = 1
        for i in range(1,n+1):
            res *= i
        return res
    
    def makelist(self, row):
        if row == 1:
            return [1]
        res = []
        for i in range(row):
            res.append(self.fac(row-1) // self.fac(i) // self.fac(row-i-1))
        return res