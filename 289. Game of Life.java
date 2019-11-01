class Solution {
    private int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
    private int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};
    private int m, n;
    public void gameOfLife(int[][] board) {
        if (board==null || board.length==0) {
            return;
        }
        m = board.length;
        n = board[0].length;
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                int count = change(board, i, j);
                if (board[j][i] >= 1) {
                    if (count < 2) {
                        board[j][i] = 2;
                    } else if (count==2 || count==3) {
                        board[j][i] = 1;
                    } else {
                        board[j][i] = 2;
                    }
                } else {
                    if (count == 3) {
                        board[j][i] = -1;
                    }
                }
            }
        }
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (board[j][i] == 2) {
                    board[j][i] = 0;
                } else if (board[j][i] == -1) {
                    board[j][i] = 1;
                }
            }
        }
        return;
    }
    private int change(int[][] board, int x, int y) {
        int count = 0;
        for (int i=0; i<8; i++) {
            if (x + dx[i] >= 0 && x + dx[i] < n && y + dy[i] >= 0 && y + dy[i] < m && board[y+dy[i]][x+dx[i]] >= 1) {
                count++;
            }
        }
        return count;
    }
}