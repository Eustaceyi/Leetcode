class UF:
    def __init__(self, n):
        self.ids = [i for i in range(n)]
        
    def root(self, a):
        while a != self.ids[a]:
            self.ids[a] = self.ids[self.ids[a]]
            a = self.ids[a]
        return a
            
    def find(self, a, b):
        return self.root(a) == self.root(b)
    
    def union(self, a, b):
        ra = self.root(a)
        rb = self.root(b)
        self.ids[ra] = rb

class Solution:
    def findRedundantConnection(self, edges: List[List[int]]) -> List[int]:
        uf = UF(len(edges)+1)
        for n1, n2 in edges:
            if uf.find(n1,n2):
                return [n1,n2]
            uf.union(n1, n2)