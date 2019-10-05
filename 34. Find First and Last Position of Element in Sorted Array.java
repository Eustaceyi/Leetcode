class Solution {
    public int[] searchRange(int[] nums, int target) {
        /**
         * Leftmost search and Rightmost search
         * Time O(logn)
         * Space O(1)
         */
        if (nums == null || nums.length == 0) {
            return new int[] {-1,-1};
        }
        int[] res = new int[2];
        int lo = 0;
        int hi = nums.length;
        while (lo < hi) {
            int mid = (hi - lo)/2 + lo;
            if (nums[mid] < target) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        if (lo >= nums.length || nums[lo] != target) {
            return new int[] {-1,-1};
        }
        res[0] = lo;
        lo = 0;
        hi = nums.length;
        while (lo < hi) {
            int mid = (hi - lo)/2 + lo;
            if (nums[mid] <= target) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        res[1] = lo - 1;
        return res;
    }
}