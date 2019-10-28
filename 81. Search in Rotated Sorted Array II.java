class Solution {
    public boolean search(int[] nums, int target) {
        int lo=0, hi=nums.length-1;
        // binary search to find
        while (lo<=hi) {
            int mid = (hi-lo)/2+lo;
            // if we find, we return true
            if (nums[mid]==target) return true;
            // right part is sorted
            if (nums[mid] < nums[lo]) {
                // if target is in left part
                if (nums[mid] > target || target > nums[hi]) {
                    hi = mid-1;
                } else { // target in right part
                    lo = mid+1; 
                }
            // left part is sorted
            } else if (nums[mid] > nums[lo]) {
                // if target is in right part
                if (nums[mid] < target || target < nums[lo]) {
                    lo = mid+1;
                } else { // target in left part
                    hi = mid-1;
                }
            } else { // now nums[mid] == nums[lo], we need to move lo to dedup
                lo++;
            }
        }
        return false;
    }
}