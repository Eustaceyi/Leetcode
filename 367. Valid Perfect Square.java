class Solution {
    public boolean isPerfectSquare(int num) {
        if (num <= 0) {
            return false;
        }
        int lo = 1, hi = num/2+1;
        while (lo <= hi) {
            int mid = (hi-lo)/2+lo;
            if (mid*1.0 == (double)num/(double)mid) {
                return true;
            } else if (mid*1.0 < (double)num/(double)mid) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return false;
    }
}