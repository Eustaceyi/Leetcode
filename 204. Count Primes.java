class Solution {
    public int countPrimes(int n) {
        if (n==0 || n==1) return 0;
        boolean[] dp = new boolean[n];
        Arrays.fill(dp, true);
        dp[0]=false;
        dp[1]=false;
        for (int i=2; i<Math.sqrt(n); i++) {
            if (dp[i] == true) {
                for (int t = 2*i; t < n; t+=i) {
                    dp[t] = false;
                }
            }
        }
        //System.out.println(Arrays.toString(dp));
        int count = 0;
        for (int i=0; i<n; i++) {
            if (dp[i]) {
                count++;
            }
        }
        return count;
    }
}