class Solution {
    int row, col;
    public boolean exist(char[][] board, String word) {
        if (board==null || board.length==0 || word==null || word.length()==0) {
            return false;
        }
        row = board.length;
        col = board[0].length;
        for (int i=0; i<row; i++) {
            for (int j=0; j<col; j++) {
                if (board[i][j]==word.charAt(0)) {
                    boolean res = dfs(board, word, i, j, 0);
                    if (res) return res;
                }
            }
        }
        return false;
    }
    private boolean dfs(char[][] board, String word, int row, int col, int pos) {
        if (pos == word.length()) return true;
        if (row < 0 || row >= this.row || col < 0 || col >= this.col) {
            return false;
        }
        if (word.charAt(pos) == board[row][col]) {
            char temp = board[row][col];
            board[row][col] = '#';
            boolean res = dfs(board, word, row+1, col, pos+1) ||
            dfs(board, word, row-1, col, pos+1) ||
            dfs(board, word, row, col-1, pos+1) ||
            dfs(board, word, row, col+1, pos+1);
            board[row][col] = temp;
            return res;
        }
        return false;
    }
}