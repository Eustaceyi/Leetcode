class Solution {
    public int maxCount(int m, int n, int[][] ops) {
        int maxm = m+1, maxn = n+1;
        for (int[] op : ops) {
            maxm = Math.min(maxm, op[0]);
            maxn = Math.min(maxn, op[1]);
        }
        return maxm == m+1 ? m * n : maxm * maxn;
    }
}