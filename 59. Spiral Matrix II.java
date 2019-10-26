class Solution {
    public int[][] generateMatrix(int n) {
        int[][] ans = new int[n][n];
        int[] dirx = {0, 1, 0, -1};
        int[] diry = {1, 0, -1, 0};
        int x = 0, y = 0, d=0;
        HashSet<Integer> seen = new HashSet<>();
        for (int i=0; i<n*n; i++) {
            ans[x][y] = i+1;
            seen.add(x*n+y);
            int tempx = x+dirx[d], tempy = y+diry[d];
            if (tempx < 0 || tempx > n-1 || tempy < 0 || tempy > n-1 || seen.contains(tempx*n+tempy)) {
                d = (d + 1) % 4;
            }
            x = x + dirx[d];
            y = y + diry[d];
        }
        return ans;
    }
}