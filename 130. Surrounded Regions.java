class Solution {
    char[][] board;
    int wid;
    int hei;
    public void solve(char[][] board) {
        if (board==null || board.length==0) {
            return;
        }
        this.board = board;
        hei = board.length;
        wid = board[0].length;
        for (int i=0; i<wid; i++) {
            check(i, 0);
            check(i, hei-1);
        }
        for (int i=0; i<hei; i++) {
            check(0, i);
            check(wid-1, i);
        }
        
        for (int i=0; i<hei; i++){
            for (int j=0; j<wid; j++) {
                if (board[i][j] == '#') {
                    board[i][j] = 'O';
                } else {
                    board[i][j] = 'X';
                }
            }
        }
    }
    private void check(int x, int y) {
        if (x < 0 || x >= wid || y < 0 || y >= hei) {
            return;
        }
        if (board[y][x] == 'O') {
            board[y][x] = '#';
            check(x + 1, y);
            check(x - 1, y);
            check(x, y + 1);
            check(x, y - 1);
        }
    }
}