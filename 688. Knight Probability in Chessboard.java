class Solution {
    private static final List<int[]> dir = new ArrayList<int[]>() {{
        add(new int[] {-1,-2});
        add(new int[] {-2,-1});
        add(new int[] {-1,2});
        add(new int[] {-2,1});
        add(new int[] {1,-2});
        add(new int[] {2,-1});
        add(new int[] {1,2});
        add(new int[] {2,1});
    }};
    /**
     * use dp array to record each probability
     * @param N
     * @param K
     * @param r
     * @param c
     * @return
     */
    public double knightProbability(int N, int K, int r, int c) {
        // these two arrays to store curr step and next step
        double[][] dp = new double[N][N], dpl = new double[N][N];
        // initial state
        dp[r][c] = 1.0;
        // calculate next step for each pos
        for (; K>0; K--) {
            for (int i=0; i<N; i++) {
                for (int j=0; j<N; j++) {
                    for (int[] d : dir) {
                        int newr = i+d[0];
                        int newc = j+d[1];
                        if (newr >= 0 && newr < N && newc >= 0 && newc < N) {
                            dpl[newr][newc] += dp[i][j] / 8.0;
                        }
                    }
                }
            }
            // swap the two states
            double[][] temp = dp;
            dp = dpl;
            dpl = temp;
            // set all to zero of next step
            for (int i=0; i<N; i++) {
                Arrays.fill(dpl[i], 0.0);
            }
        }
        // sum of all pos's probability is the final ans
        double ans = 0.0;
        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                ans += dp[i][j];
            }
        }
        return ans;
    }
}