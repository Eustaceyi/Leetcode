class Solution {
    public int maxSumTwoNoOverlap(int[] A, int L, int M) {
        if (A == null || A.length < L+M) {
            return 0;
        }
        int[] presum = new int[A.length+1];
        presum[0] = 0;
        for (int i=0; i<A.length; i++) {
            presum[i+1] = presum[i] + A[i];
        }
        int res = presum[L+M], l = presum[L], m = presum[M];
        for (int i = L+M+1; i<presum.length; i++) {
            l = Math.max(l, presum[i-M] - presum[i-L-M]);
            m = Math.max(m, presum[i-L] - presum[i-M-L]);
            res = Math.max(res, Math.max(l + presum[i]-presum[i-M], m + presum[i] - presum[i-L]));
        }
        return res;
    }
}