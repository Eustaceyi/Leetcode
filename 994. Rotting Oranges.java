class Solution {
    public int orangesRotting(int[][] grid) {
        if (grid==null || grid.length == 0 || grid[0]==null || grid[0].length==0) {
            return 0;
        }
        int m=grid.length, n=grid[0].length;
        int fresh = 0;
        int level = 0;
        Queue<Integer> q = new ArrayDeque<>();
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (grid[i][j] == 1) {
                    fresh++;
                } else if (grid[i][j] == 2) {
                    q.offer(i*n+j);
                }
            }
        }
        if (fresh==0) {
            return 0;
        }
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i=0; i<size; i++) {
                int pos = q.poll();
                int r = pos/n, c = pos%n;
                if (r > 0 && grid[r-1][c] == 1) {
                    grid[r-1][c] = 2;
                    q.offer((r-1)*n+c);
                    fresh--;
                }
                if (r < m-1 && grid[r+1][c] == 1) {
                    grid[r+1][c] = 2;
                    q.offer((r+1)*n+c);
                    fresh--;
                }
                if (c > 0 && grid[r][c-1] == 1) {
                    grid[r][c-1] = 2;
                    q.offer(r*n+c-1);
                    fresh--;
                }
                if (c < n-1 && grid[r][c+1] == 1) {
                    grid[r][c+1] = 2;
                    q.offer(r*n+c+1);
                    fresh--;
                }
            }
            level++;
        }
        if (fresh > 0) {
            return -1;
        } else {
            return level-1;
        }
    }
}