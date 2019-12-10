class TicTacToe {
    int[] row1, col1, row2, col2;
    int slash1, back1, slash2, back2;
    int n;

    /** Initialize your data structure here. */
    public TicTacToe(int n) {
        row1 = new int[n];
        col1 = new int[n];
        slash1 = 0;
        back1 = 0;
        row2 = new int[n];
        col2 = new int[n];
        slash2 = 0;
        back2 = 0;
        this.n = n;
    }
    
    /** Player {player} makes a move at ({row}, {col}).
        @param row The row of the board.
        @param col The column of the board.
        @param player The player, can be either 1 or 2.
        @return The current winning condition, can be either:
                0: No one wins.
                1: Player 1 wins.
                2: Player 2 wins. */
    public int move(int row, int col, int player) {
        if (player==1) {
            row1[row]++;
            col1[col]++;
            if (row==col) {
                slash1++;
            }
            if (row+col==n-1) {
                back1++;
            }
            if (row1[row]==n || col1[col]==n || slash1==n || back1==n) {
                return 1;
            } else {return 0;}
        } else {
            row2[row]++;
            col2[col]++;
            if (row==col) {
                slash2++;
            }
            if (row+col==n-1) {
                back2++;
            }
            if (row2[row]==n || col2[col]==n || slash2==n || back2==n) {
                return 2;
            } else {return 0;}
        }
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */