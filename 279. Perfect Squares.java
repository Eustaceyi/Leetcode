/**
 * dp solution, calculate the squares that smaller than curr number
 * and we pick the smallest combination
 * time O(n * sqrt(n))
 * space O(n)
 */
class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i=1; i<=n; i++) {
            for (int j=1; j*j<=i; j++) {
                dp[i] = Math.min(dp[i], 1+dp[i-j*j]);
            }
        }
        return dp[n];
    }
}

/**
 * Math solution,
 * 1. if n = 4^k*(8n+7) then it must be break down into 4 numbers
 * 2. if n is square, then ans is 1
 * 3. loop to find out if it can be shown as two square's sum
 * 4. no solution shown above, then ans is 3
 * time O(sqrt(n))
 * space O(1) 
 */
class Solution {

    protected boolean isSquare(int n) {
      int sq = (int) Math.sqrt(n);
      return n == sq * sq;
    }
  
    public int numSquares(int n) {
      // four-square and three-square theorems.
      while (n % 4 == 0)
        n /= 4;
      if (n % 8 == 7)
        return 4;
  
      if (this.isSquare(n))
        return 1;
      // enumeration to check if the number can be decomposed into sum of two squares.
      for (int i = 1; i * i <= n; ++i) {
        if (this.isSquare(n - i * i))
          return 2;
      }
      // bottom case of three-square theorem.
      return 3;
    }
  }