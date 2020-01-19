/**
 * DFS solution, finding all feasible patterns
 */
class Solution {
    public int numberOfPatterns(int m, int n) {
        // this skip matrix marks all skip points that we need to check
        int[][] skip = new int[10][10];
        skip[1][3] = skip[3][1] = 2;
        skip[1][7] = skip[7][1] = 4;
        skip[3][9] = skip[9][3] = 6;
        skip[7][9] = skip[9][7] = 8;
        skip[1][9] = skip[9][1] = skip[2][8] = skip[8][2] = skip[3][7] = skip[7][3] = skip[4][6] = skip[6][4] = 5;
        boolean[] vis = new boolean[10];
        int[] ret = new int[]{0};
        int ans = 0;
        // start from 1, and consider that 1, 3, 7, 9 are symmetric
        dfs(1, 1, m, n, ret, skip, vis);
        ans += ret[0] * 4;
        ret[0] = 0;
        // start from 2, and consider that 2, 4, 6, 8 are symmetric
        dfs(2, 1, m, n, ret, skip, vis);
        ans += ret[0] * 4;
        ret[0] = 0;
        // start from 5
        dfs(5, 1, m, n, ret, skip, vis);
        ans += ret[0];
        return ans;
    }
  
    private void dfs(int cur, int l, int m, int n, int[] ret, int[][] skip, boolean[] vis) {
        // if currlen is equal or larger than m, then this could be a path
        if (l >= m) ret[0]++;
        // no need to explore more
        if (l >= n) return;
        // set curr as visited
        vis[cur] = true;
        // finding feasible next step
        for (int next = 1; next <= 9; next++) {
            if (!vis[next] && (skip[cur][next] == 0 || vis[skip[cur][next]])) {
                dfs(next, l+1, m, n, ret, skip, vis);
            }
        }
        vis[cur] = false;
    }
}