/**
 * DFS recursion
 * Time O(r*c)
 * Space O(r*c)
 */
class Solution {
    char[][] grid;
    int row, col;
    public int numIslands(char[][] grid) {
        int count = 0;
        if (grid==null || grid.length==0) {
            return count;
        }
        this.grid = grid;
        row = grid.length;
        col = grid[0].length;
        for (int i=0; i<row; i++) {
            for (int j=0; j<col; j++) {
                if (grid[i][j] == '1') {
                    dfs(i, j);
                    count++;
                }
            }
        }
        return count;
    }
    private void dfs(int i, int j) {
        if (i<0 || i>=row || j<0 || j>=col || grid[i][j] == '0') {
            return;
        }
        grid[i][j] = '0';
        dfs(i+1, j);
        dfs(i-1, j);
        dfs(i, j+1);
        dfs(i, j-1);
    }
}
/**
 * DFS iteration
 * Time O(r*c)
 * Space O(r*c)
 */
class Solution {
    char[][] grid;
    int row, col;
    public int numIslands(char[][] grid) {
        int count = 0;
        if (grid==null || grid.length==0) {
            return count;
        }
        this.grid = grid;
        row = grid.length;
        col = grid[0].length;
        for (int i=0; i<row; i++) {
            for (int j=0; j<col; j++) {
                if (grid[i][j] == '1') {
                    Deque<Integer> stack = new ArrayDeque<>();
                    stack.push(i*col+j);
                    grid[i][j] = '0';
                    while (!stack.isEmpty()) {
                        int pos = stack.pop();
                        int r = pos/col, c = pos%col;
                        if (r>0 && grid[r-1][c] =='1') {
                            grid[r-1][c] = '0';
                            stack.push((r-1)*col+c);
                        }
                        if (r < row-1 && grid[r+1][c]=='1') {
                            grid[r+1][c] = '0';
                            stack.push((r+1)*col+c);
                        }
                        if (c > 0 && grid[r][c-1]=='1') {
                            grid[r][c-1] = '0';
                            stack.push(r*col+c-1);
                        }
                        if (c < col-1 && grid[r][c+1]=='1') {
                            grid[r][c+1] = '0';
                            stack.push(r*col+c+1);
                        }
                    }
                    count++;
                }
            }
        }
        return count;
    }
}
/**
 * BFS iteration
 * Time O(r*c)
 * Spcae O(min(r*c))
 */
class Solution {
    char[][] grid;
    int row, col;
    public int numIslands(char[][] grid) {
        int count = 0;
        if (grid==null || grid.length==0) {
            return count;
        }
        this.grid = grid;
        row = grid.length;
        col = grid[0].length;
        for (int i=0; i<row; i++) {
            for (int j=0; j<col; j++) {
                if (grid[i][j] == '1') {
                    Deque<Integer> queue = new ArrayDeque<>();
                    queue.offerLast(i*col+j);
                    grid[i][j] = '0';
                    while (!queue.isEmpty()) {
                        int pos = queue.pollFirst();
                        int r = pos/col, c = pos%col;
                        if (r>0 && grid[r-1][c] =='1') {
                            grid[r-1][c] = '0';
                            queue.offerLast((r-1)*col+c);
                        }
                        if (r < row-1 && grid[r+1][c]=='1') {
                            grid[r+1][c] = '0';
                            queue.offerLast((r+1)*col+c);
                        }
                        if (c > 0 && grid[r][c-1]=='1') {
                            grid[r][c-1] = '0';
                            queue.offerLast(r*col+c-1);
                        }
                        if (c < col-1 && grid[r][c+1]=='1') {
                            grid[r][c+1] = '0';
                            queue.offerLast(r*col+c+1);
                        }
                    }
                    count++;
                }
            }
        }
        return count;
    }
}
/**
 * Union Find solution
 * Time O(r*c*time of find)
 * Spcae O(r*c)
 */
class Solution {
    public int numIslands(char[][] grid) {
        if (grid==null || grid.length==0) {
            return 0;
        }
        int row = grid.length;
        int col = grid[0].length;
        UF uf = new UF(row*col);
        for (int i=0; i<row; i++) {
            for (int j=0; j<col; j++) {
                if (grid[i][j] == '1'){
                    if (i > 0 && grid[i-1][j] =='1') {
                        uf.union(i*col-col+j, i*col+j);
                    }
                    if (j > 0 && grid[i][j-1] == '1') {
                        uf.union(i*col+j-1, i*col+j);
                    }
                }
            }
        }
        HashSet<Integer> set = new HashSet<>();
        for (int i=0; i<row; i++) {
            for (int j=0; j<col; j++) {
                if (grid[i][j] == '1' && !set.contains(uf.root(i*col+j))){
                    set.add(uf.root(i*col+j));
                }
            }
        }
        return set.size();
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
    public int root(int A) {
        while (A != ids[A]) {
            ids[A] = ids[ids[A]];
            A = ids[A];
        }
        return A;
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