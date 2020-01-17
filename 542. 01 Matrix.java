/**
 * BFS solution
 * Time O(rc)
 * Space O(rc)
 */
class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        if (matrix==null || matrix.length==0 || matrix[0].length==0) {
            return matrix;
        }
        int row = matrix.length, col = matrix[0].length;
        int[][] dist = new int[row][col];
        for (int[] temp : dist) {
            Arrays.fill(temp, Integer.MAX_VALUE);
        }
        Deque<int[]> dq = new ArrayDeque<>();
        int[][] dir = {{0,1}, {1,0}, {-1,0}, {0,-1}};
        for (int i=0; i<row; i++) {
            for (int j=0; j<col; j++) {
                if (matrix[i][j] == 0) {
                    dist[i][j] = 0;
                    dq.offer(new int[] {i,j});
                }
            }
        }
        while (!dq.isEmpty()) {
            int[] p = dq.poll();
            for (int[] d : dir) {
                int newr = p[0] + d[0];
                int newc = p[1] + d[1];
                if (newr>=0 && newr<row && newc>=0 && newc<col) {
                    if (dist[newr][newc] > dist[p[0]][p[1]]+1) {
                        dist[newr][newc] = dist[p[0]][p[1]]+1;
                        dq.offer(new int[] {newr, newc});
                    }
                }
            }
        }
        return dist;
    }
}

/**
 * DP solution
 * we do two pass,
 * first we check from upleft to downright
 * then we do another from downright to upleft
 */
class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        if (matrix==null || matrix.length==0 || matrix[0].length==0) {
            return matrix;
        }
        int row = matrix.length, col = matrix[0].length;
        int[][] dist = new int[row][col];
        for (int[] temp : dist) {
            Arrays.fill(temp, Integer.MAX_VALUE-10000); // this -10000 is import, if we failure to do so, we may overflow
        }
        for (int i=0; i<row; i++) {
            for (int j=0; j<col; j++) {
                if (matrix[i][j]==0) {
                    dist[i][j] = 0;
                } else {
                    if (i > 0) {
                        dist[i][j] = Math.min(dist[i][j], dist[i-1][j]+1);
                    }
                    if (j > 0) {
                        dist[i][j] = Math.min(dist[i][j], dist[i][j-1]+1);
                    }
                }
            }
        }
        
        for (int i=row-1; i>=0; i--) {
            for (int j=col-1; j>=0; j--) {
                if (i < row-1) {
                    dist[i][j] = Math.min(dist[i][j], dist[i+1][j]+1);
                }
                if (j < col-1) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][j+1]+1);
                }
            }
        }
        return dist;
    }
}