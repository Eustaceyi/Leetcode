class Solution {
    public int maxKilledEnemies(char[][] grid) {
        int maxkill = 0;
        if (grid==null || grid.length==0 || grid[0].length==0) {
            return maxkill;
        }
        int row = grid.length, col = grid[0].length;
        // variable for recording rowkills
        int rowcount = 0;
        // var for revording colkills
        int[] colcount = new int[col];
        for (int i=0; i<row; i++) {
            for (int j=0; j<col; j++) {
                // if we encounter new row or in this row we meet a wall
                // we calculate the new kills in row
                if (j == 0 || grid[i][j-1] == 'W') {
                    rowcount = 0;
                    for (int k = j; k < col; k++) {
                        if (grid[i][k]=='E') {rowcount++;}
                        else if (grid[i][k]=='W') {break;}
                    }
                }

                // if we encounter wall or init colcount
                if (i == 0 || grid[i-1][j] == 'W') {
                    colcount[j] = 0;
                    for (int k = i; k<row; k++) {
                        if (grid[k][j]=='E') {colcount[j]++;}
                        else if (grid[k][j]=='W') {break;}
                    }
                }

                // we only update if we can palce a bomb there
                if (grid[i][j] == '0') {
                    maxkill = Math.max(maxkill, rowcount + colcount[j]);
                }
            }
        }
        return maxkill;
    }
}