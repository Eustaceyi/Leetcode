class Route implements Comparable<Route> {
    int score;
    int row;
    int col;
    public Route(int score, int row, int col) {
        this.score = score;
        this.row = row;
        this.col = col;
    }
    public int compareTo(Route that) {
        return that.score - this.score;
    }
}
/**
 * Dijkstra
 * the visit once seems work is because that if we visit this point, other points are all having lower scores
 * so this point we dont need to go again
 */
class Solution {
    public int maximumMinimumPath(int[][] A) {
        if (A==null || A.length==0 || A[0]==null || A[0].length==0) {
            return -1;
        } 
        int[][] dir = {{0,1}, {1,0}, {0, -1}, {-1, 0}};
        int row = A.length;
        int col = A[0].length;
        PriorityQueue<Route> pq = new PriorityQueue<>();
        pq.offer(new Route(A[0][0], 0, 0));
        int maxscore = A[0][0];
        A[0][0] = -1;
        while (!pq.isEmpty()) {
            Route temp = pq.poll();
            maxscore = Math.min(maxscore, temp.score);
            if (temp.row == row-1 && temp.col == col-1) {
                return maxscore;
            }
            for (int[] d : dir) {
                int newr = temp.row+d[0];
                int newc = temp.col+d[1];
                if (newr < row && newr >= 0 && newc < col && newc >= 0 && A[newr][newc] >= 0) {
                    pq.offer(new Route(A[newr][newc], newr, newc));
                    A[newr][newc] = -1;
                }
            }
        }
        return -1;
    }
}
