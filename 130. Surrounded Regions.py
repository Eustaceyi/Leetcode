class Solution:
    def solve(self, board: List[List[str]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        This is a DFS with recursion, but can also be done by DFS with stack or BFS with queue
        """
        if not board:
            return
        h, w = len(board), len(board[0])
        for i in range(h):
            self.helper(board, i, 0)
            self.helper(board, i, w-1)
        for i in range(w):
            self.helper(board, 0, i)
            self.helper(board, h-1, i)
        
        for i in range(h):
            for j in range(w):
                if board[i][j] == 'D':
                    board[i][j] = 'O'
                else:
                    board[i][j] = 'X'
                        
    def helper(self, board, i, j):
        if i < 0 or i >= len(board):
            return
        if j < 0 or j >= len(board[0]):
            return
        if board[i][j] == 'O':
            board[i][j] = 'D'
            self.helper(board, i+1, j)
            self.helper(board, i, j+1)
            self.helper(board, i-1, j)
            self.helper(board, i, j-1)

class UF:
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

class Solution:
    def solve(self, board: List[List[str]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        A Union Find solution, keep 'O's on the boundry connected to a dummy node and change other 'O's into 'X'
        """
        if not board:
            return 
        m = len(board)
        n = len(board[0])
        uf = UF(m*n+1)
        for i in range(m):
            for j in range(n):
                if (i == 0 or i == m-1 or j == 0 or j == n-1) and board[i][j] == 'O':
                    uf.union(n*i+j, m*n)
                elif board[i][j] == 'O':
                    if board[i+1][j] == 'O':
                        uf.union(i*n+j, (i+1)*n+j)
                    if board[i-1][j] == 'O':
                        uf.union(i*n+j, (i-1)*n+j)
                    if board[i][j+1] == 'O':
                        uf.union(i*n+j, i*n+j+1)
                    if board[i][j-1] == 'O':
                        uf.union(i*n+j, i*n+j-1)
        for i in range(m):
            for j in range(n):
                if board[i][j] == 'O' and not uf.find(i*n+j, m*n):
                    board[i][j] = 'X'
        