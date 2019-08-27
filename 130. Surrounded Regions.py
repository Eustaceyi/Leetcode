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