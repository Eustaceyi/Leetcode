class Solution {
    public int search(int[] nums, int target) {
        /**
         * Very good Binary Search question.
         * the key point is to find out where the rotation point is,
         * then use normal binary search to find out the target
         * Time O(logn)
         * Space O(1)
         */
        int lo = 0;
        int hi = nums.length-1;
        while (lo <= hi) {
            int mid = (hi - lo)/2 + lo;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[lo] <= nums[mid]) {
                if (target >= nums[lo] && target < nums[mid]) hi = mid-1;
                else lo = mid+1;
            } else {
                if (target > nums[mid] && target <= nums[hi]) lo = mid+1;
                else hi = mid-1;
            }
        }
        return -1;
    }
}