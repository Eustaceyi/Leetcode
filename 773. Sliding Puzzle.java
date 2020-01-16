/**
 * Do a BFS search to search solution level by level
 */
class Solution {
    private static final String dest = "123450";
    private static final int[][] dir = new int[][] {{0,1},{1,0},{-1,0},{0,-1}};
    
    class Board {
        int row, col;
        int[][] board;
        public Board(int[][] board, int row, int col) {
            this.board = new int[board.length][board[0].length];
            for (int i=0; i<board.length; i++) {
                for (int j=0; j<board[0].length; j++) {
                    this.board[i][j] = board[i][j];
                }
            }
            this.row = row;
            this.col = col;
        }
        public String toString() {
            StringBuilder sb = new StringBuilder();
            for (int[] line : board) {
                for (int i : line) {
                    sb.append(i);
                }
            }
            return sb.toString();
        }
    }
    
    private int[][] swap(int[][] board, int orir, int oric, int newr, int newc) {
        int[][] newboard = new int[board.length][board[0].length];
        for (int i=0; i<board.length; i++) {
            for (int j=0; j<board[0].length; j++) {
                newboard[i][j] = board[i][j];
            }
        }
        int temp = newboard[orir][oric];
        newboard[orir][oric] = newboard[newr][newc];
        newboard[newr][newc] = temp;
        return newboard;
    }
    
    public int slidingPuzzle(int[][] board) {
        Set<String> seen = new HashSet<>();
        Deque<Board> q = new ArrayDeque<>();
        int r = 0, c = 0, row = board.length, col = board[0].length;
        
        search:
        for (int i=0; i<board.length; i++) {
            for (int j=0; j<board[0].length; j++) {
                if (board[i][j]==0) {
                    r = i; c = j;
                    break search;
                }
            }
        }
        Board curr = new Board(board, r, c);
        if (curr.toString().equals(dest)) {
            return 0;
        }
        q.offer(curr);
        seen.add(curr.toString());
        int level = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            level++;
            for (int i = 0; i < size; i++) {
                curr = q.poll();
                for (int[] d : dir) {
                    if (curr.row + d[0] >=0 && curr.row + d[0] < row && curr.col + d[1] >= 0 && curr.col + d[1] < col) {
                        int[][] newboard = swap(curr.board, curr.row, curr.col, curr.row + d[0], curr.col + d[1]);
                        Board next = new Board(newboard, curr.row + d[0], curr.col + d[1]);
                        if (next.toString().equals(dest)) {
                            return level;
                        }
                        if (!seen.contains(next.toString())) {
                            seen.add(next.toString());
                            q.offer(next);
                        }
                    }
                }
            } 
        }
        return -1;
    }
}