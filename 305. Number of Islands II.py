class UF:
    def __init__(self):
        self.ids = {}
        self.count = 0
        self.size = {}
        
    def root(self, A):
        while A != self.ids[A]:
            self.ids[A] = self.ids[self.ids[A]]
            A = self.ids[A]
        return A
    
    def add(self, A):
        self.ids[A] = A
        self.size[A] = 1
        self.count += 1
        
    def union(self, A, B):
        i = self.root(A)
        j = self.root(B)
        if i == j:
            return
        if self.size[i] > self.size[j]:
            i, j = j, i
        self.ids[i] = j
        self.size[j] += self.size[i]
        self.count -= 1

class Solution:
    def numIslands2(self, m: int, n: int, positions: List[List[int]]) -> List[int]:
        '''
        Union find solution
        '''
        uf = UF()
        res = []
        for i,j in positions:
            if (i,j) in uf.ids:
                res.append(uf.count)
                continue
            uf.add((i,j))
            if (i-1,j) in uf.ids:
                uf.union((i,j), (i-1,j))
            if (i+1,j) in uf.ids:
                uf.union((i,j), (i+1,j))
            if (i,j-1) in uf.ids:
                uf.union((i,j), (i,j-1))
            if (i,j+1) in uf.ids:
                uf.union((i,j), (i,j+1))
            res.append(uf.count)
        return res