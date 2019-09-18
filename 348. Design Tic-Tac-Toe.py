class TicTacToe:

    def __init__(self, n):
        """
        Initialize your data structure here.
        """
        self.n = n
        self.rows = [0 for _ in range(n)]
        self.cols = [0 for _ in range(n)]
        self.diag = [0, 0]

    def move(self, row, col, player):
        """
        Player {player} makes a move at ({row}, {col}).
        @param row The row of the board.
        @param col The column of the board.
        @param player The player, can be either 1 or 2.
        @return The current winning condition, can be either:
                0: No one wins.
                1: Player 1 wins.
                2: Player 2 wins.
        """
        self.rows[row] += 1 if player == 1 else -1
        if self.rows[row] == self.n:
            return 1
        elif self.rows[row] == -self.n:
            return 2
        
        self.cols[col] += 1 if player == 1 else -1
        if self.cols[col] == self.n:
            return 1
        elif self.cols[col] == -self.n:
            return 2
        
        if col==row:
            self.diag[0] += 1 if player == 1 else -1
            if self.diag[0] == self.n:
                return 1
            elif self.diag[0] == -self.n:
                return 2
        if col+row == self.n-1:
            self.diag[1] += 1 if player == 1 else -1
            if self.diag[1] == self.n:
                return 1
            elif self.diag[1] == -self.n:
                return 2
        return 0

# Your TicTacToe object will be instantiated and called as such:
# obj = TicTacToe(n)
# param_1 = obj.move(row,col,player)