/**
 * custom binary search
 */
class Solution {
    public int findMin(int[] nums) {
        int lo = 0, hi = nums.length-1;
        while (lo < hi) {
            int mid = (hi-lo)/2+lo;
            if (nums[mid+1] < nums[mid]) {
                return nums[mid+1];
            }
            if (nums[mid] < nums[lo]) {
                hi = mid;
            } else if (nums[mid] > nums[hi]){
                lo = mid;
            } else {
                return nums[lo];
            }
        }
        return nums[lo];
    }
}