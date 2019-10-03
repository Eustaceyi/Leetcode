class QuickFind:
    '''
    Find quick, but union slow. It may take ~MN steps to process M union commands on N objects
    '''
    def __init__(self, N):
        '''
        Union Find with N nodes
        '''
        self.ids = [i for i in range(N)]

    def find(self, A, B):
        '''
        A & B are two nodes of N
        '''
        return self.ids[A] == self.ids[B]

    def union(self, A, B):
        Aid = self.ids[A]
        for i in range(len(self.ids)):
            if self.ids[i] == Aid:
                self.ids[i] = self.ids[B]

class QuickUnion:
    '''
    Trees can get tall.
    Find too expensive (could be N steps)
    Need to do find to do union
    '''
    def __init__(self,N):
        self.ids = [i for i in range(N)]
    
    def root(self, A):
        while A != self.ids[A]:
            A = self.ids[A]
        return A 

    def find(self, A, B):
        return self.root(A) == self.root(B)

    def union(self, A, B):
        i = self.root(A)
        j = self.root(B)
        self.ids[i] = j

class WQUPC:
    '''
    Weighted Quick Union with Path Compression
    Flatten Tree, Quick union
    '''
    def __init__(self, N):
        self.ids = [i for i in range(N)]

    def root(self, A):
        while A != self.ids[A]:
            self.ids[A] = self.ids[self.ids[A]]
            A = self.ids[A]
        return A
    
    def find(self, A, B):
        return self.root(A) == self.root(B)

    def union(self, A, B):
        i = self.root(A)
        j = self.root(B)
        self.ids[i] = j 