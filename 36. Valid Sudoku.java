class Solution {
    private char[][] board;
    public boolean isValidSudoku(char[][] board) {
        this.board = board;
        boolean isValid = true;
        for (int i=0; i<9; i++) {
            isValid = isValid && checkRow(i) && checkCol(i) && checkBlock(i);
        }
        return isValid;
    }
    private boolean checkRow(int row) {
        boolean[] check = new boolean[9];
        for (int i=0; i<9; i++) {
            if (Character.isDigit(board[row][i])) {
                int t = board[row][i]-'1';
                if (check[t]) {
                    return false;
                } else {
                    check[t] = true;
                }
            }
        }
        return true;
    }
    private boolean checkCol(int col) {
        boolean[] check = new boolean[9];
        for (int i=0; i<9; i++) {
            if (Character.isDigit(board[i][col])) {
                int t = board[i][col]-'1';
                if (check[t]) {
                    return false;
                } else {
                    check[t] = true;
                }
            }
        }
        return true;
    }
    private boolean checkBlock(int pos) {
        boolean[] check = new boolean[9];
        int r = pos/3*3, c = pos%3*3;
        for (int i=0; i<3; i++) {
            for (int j=0; j<3; j++) {
                if (Character.isDigit(board[i+r][j+c])) {
                    int t = board[i+r][j+c]-'1';
                    if (check[t]) {
                        return false;
                    } else {
                        check[t] = true;
                    }
                }
            }
        }
        return true;
    }
}