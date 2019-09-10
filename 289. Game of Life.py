class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        self.row = len(board)
        self.col = len(board[0])
        pos = [(-1,-1), (-1,0), (-1,1), (0,-1), (0,1), (1,-1), (1,0), (1,1)]
        for i in range(self.row):
            for j in range(self.col):
                count = 0
                for x,y in pos:
                    count += self.checkaround(board, i+x, j+y)
                if board[i][j] == 0:
                    if count == 3:
                        board[i][j] = 2
                else:
                    if count < 2 or count > 3:
                        board[i][j] = -1
        for i in range(self.row):
            for j in range(self.col):
                if board[i][j] > 0:
                    board[i][j] = 1
                else:
                    board[i][j] = 0
                    
    def checkaround(self, board, i, j):
        if i < 0 or i >= self.row or j < 0 or j >= self.col:
            return 0
        elif board[i][j] == 1 or board[i][j] == -1:
            return 1
        else:
            return 0