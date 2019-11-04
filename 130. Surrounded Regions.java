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
/**
 * Union find - not very suitable with this problem
 */
class Solution {
    public void solve(char[][] board) {
        if (board==null || board.length==0) {
            return;
        }
        int row = board.length, col = board[0].length;
        UF uf = new UF(row*col+1);
        int dummy = row*col;
        for (int i=0; i<row; i++) {
            for (int j=0; j<col; j++) {
                if (board[i][j] == 'O') {
                    if (i==0 || i==row-1 || j==0 || j==col-1) {
                        uf.union(i*col+j, dummy);
                    } else {
                        if (board[i-1][j] == 'O') {
                            uf.union(i*col+j, i*col-col+j);
                        }
                        if (board[i][j-1] == 'O') {
                            uf.union(i*col+j, i*col+j-1);
                        }
                        if (board[i+1][j] == 'O') {
                            uf.union(i*col+j, i*col+col+j);
                        }
                        if (board[i][j+1] == 'O') {
                            uf.union(i*col+j, i*col+j+1);
                        }
                    }
                }
            }
        }
        for (int i=0; i<row; i++) {
            for (int j=0; j<col; j++) {
                if (board[i][j] == 'O' && !uf.find(i*col+j, dummy)) {
                    board[i][j] = 'X';
                }
            }
        }
    }
}

class UF {
    int[] ids;
    public UF(int n) {
        ids = new int[n];
        for (int i=0; i<n; i++) {
            ids[i] = i;
        }
    }
    public int root(int id) {
        while (ids[id] != id) {
            ids[id] = ids[ids[id]];
            id = ids[id];
        }
        return id;
    }
    public boolean find(int A, int B) {
        return root(A) == root(B);
    }
    public void union(int A, int B) {
        int x = root(A);
        int y = root(B);
        ids[x] = y;
    }
}