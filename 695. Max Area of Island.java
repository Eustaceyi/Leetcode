/**
 * using a dfs to search the entire graph and finding out the area
 * and compare to each area
 */
class Solution {
    private int[][] grid;
    private int row, col;
    
    public int maxAreaOfIsland(int[][] grid) {
        if (grid==null || grid.length==0 || grid[0]==null || grid[0].length==0) {
            return 0;
        }
        this.grid = grid;
        row = grid.length;
        col = grid[0].length;
        int maxarea = 0;
        for (int i=0; i<row; i++) {
            for (int j=0; j<col; j++) {
                if (this.grid[i][j] == 1) {
                    maxarea = Math.max(dfs(i, j), maxarea);
                }
            }
        }
        return maxarea;
    }
    
    private int dfs(int r, int c) {
        if (r < 0 || r >= row || c < 0 || c >= col || grid[r][c]!=1) {
            return 0;
        }
        grid[r][c] = 0;
        return 1 + dfs(r-1, c) + dfs(r+1, c) + dfs(r, c+1) + dfs(r, c-1);
    }
}