class Solution {
    public int twoSumLessThanK(int[] A, int K) {
        if (A==null || A.length < 2) {
            return -1;
        }
        Arrays.sort(A);
        int lo = 0, hi = A.length-1;
        int maxsmaller = Integer.MIN_VALUE;
        while (lo < hi) {
            if (A[lo] + A[hi] < K) {
                maxsmaller = Math.max(maxsmaller, A[lo] + A[hi]);
                lo++;
            } else {
                hi--;
            }
        }
        if (maxsmaller == Integer.MIN_VALUE) {
            return -1;
        } else {
            return maxsmaller;
        }
    }
}