class Solution {
    private static final int[][] dir = {{0,1},{1,0},{-1,0},{0,-1}};
    
    public boolean hasPath(int[][] maze, int[] start, int[] dest) {
        if (maze==null || maze.length==0 || maze[0].length==0) {return false;}
        if (start[0]==dest[0] && start[1]==dest[1]) {return true;}
        int row = maze.length, col = maze[0].length;
        
        boolean[][] visited = new boolean[row][col];
        Deque<int[]> q = new ArrayDeque<>();
        visited[start[0]][start[1]] = true;
        q.offer(start);
        while (!q.isEmpty()) {
            int[] p = q.poll();
            for (int[] d : dir) {
                int newx = p[0];
                int newy = p[1];
                while (newx+d[0]>=0 && newx+d[0]<row && newy+d[1]>=0 && newy+d[1]<col && maze[newx+d[0]][newy+d[1]]==0) {
                    newx += d[0];
                    newy += d[1];
                }
                if (newx == dest[0] && newy == dest[1]) {return true;}
                if (!visited[newx][newy]) {
                    visited[newx][newy] = true;
                    q.offer(new int[] {newx, newy});
                }
            }
        }
        return false;
    }
}