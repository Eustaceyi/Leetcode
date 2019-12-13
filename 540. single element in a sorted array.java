class Solution {
    public int singleNonDuplicate(int[] nums) {
        if (nums==null || nums.length==0) {
            return 0;
        }
        int lo=0, hi=nums.length-1;
        while (lo <= hi) {
            int mid = (hi-lo)/2+lo;
            if (mid<nums.length-1 && mid%2==0 && nums[mid]==nums[mid+1]) {
                // the single one comes after this
                lo = mid+1;
            } else if (mid<nums.length-1 && mid%2!=0 && nums[mid]==nums[mid+1]) {
                // the single one comes before this
                hi = mid-1;
            } else if (mid>0 && mid%2==0 && nums[mid]==nums[mid-1]) {
                // the single one comes before this
                hi = mid-1;
            } else if (mid>0 && mid%2!=0 && nums[mid]==nums[mid-1]) {
                // the single one comes after this
                lo = mid+1;
            } else {
                return nums[mid];
            }
        }
        return 0;
    }
}