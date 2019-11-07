class Solution {
    int row, col;
    List<List<Point>> islands;
    int[][] grid;
    public int numDistinctIslands(int[][] grid) {
        if (grid==null || grid.length==0) {
            return 0;
        }
        row = grid.length;
        col = grid[0].length;
        islands = new ArrayList<>();
        this.grid = grid;
        for (int i=0; i<row; i++) {
            for (int j=0; j<col; j++) {
                if (grid[i][j] == 1) {
                    bfs(i, j, new ArrayList<>());
                }
            }
        }
        return islands.size();
    }
    
    private void bfs(int i, int j, List<Point> pos) {
        Deque<Point> dq = new ArrayDeque<>();
        dq.offer(new Point(i,j));
        grid[i][j] = 0;
        pos.add(new Point(0,0));
        while (!dq.isEmpty()) {
            Point p = dq.poll();
            int pi = p.row, pj = p.col;
            if (pi > 0 && grid[pi-1][pj] == 1) {
                dq.add(new Point(pi-1, pj));
                grid[pi-1][pj] = 0;
                pos.add(new Point(pi-1-i, pj-j));
            }
            if (pi < row-1 && grid[pi+1][pj] == 1) {
                dq.add(new Point(pi+1, pj));
                grid[pi+1][pj] = 0;
                pos.add(new Point(pi+1-i, pj-j));
            }
            if (pj > 0 && grid[pi][pj-1] == 1) {
                dq.add(new Point(pi, pj-1));
                grid[pi][pj-1] = 0;
                pos.add(new Point(pi-i, pj-1-j));
            }
            if (pj < col-1 && grid[pi][pj+1] == 1) {
                dq.add(new Point(pi, pj+1));
                grid[pi][pj+1] = 0;
                pos.add(new Point(pi-i, pj+1-j));
            }
        }
        check(pos);
    }
    
    private void check(List<Point> pos) {
        boolean contains = false;
        for (List<Point> i : islands) {
            boolean same = true;
            if (i.size() == pos.size()) {
                for (int j=0; j<i.size(); j++) {
                    if (!i.get(j).equals(pos.get(j))) {
                        same = false;
                        break;
                    }
                }
            } else {
                same = false;
            }
            contains = contains || same;
            if (contains) {
                return;
            }
        }
        islands.add(pos);
    }
}

class Point {
    int row, col;
    public Point(int row, int col){
        this.row = row;
        this.col = col;
    }
    public boolean equals(Point p) {
        return p.row==this.row && p.col==this.col;
    }
}
