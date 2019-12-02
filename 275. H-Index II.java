class Solution {
    public int hIndex(int[] c) {
        int lo = 0, hi = c.length, n=c.length;
        while (lo < hi) {
            int mid = (hi-lo)/2+lo;
            if (c[mid] >= n-mid) {
                hi = mid;
            } else {
                lo = mid+1;
            }
        }
        return n-hi;
    }
}