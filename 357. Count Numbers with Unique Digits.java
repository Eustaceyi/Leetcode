class Solution {
    private static int[] ans = new int [12];
    
    public Solution() {
        ans[0] = 1;
        ans[1] = 9;
        ans[2] = 81;
        for (int i=3; i<12; i++) {
            ans[i] = ans[i-1]*(11-i);
        }
    }
    
    public int countNumbersWithUniqueDigits(int n) {
        int ret = 0;
        for (int i=0; i<=n; i++) {
            ret += ans[i];
        }
        return ret;
    }
}