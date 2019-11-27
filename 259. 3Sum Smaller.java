class Solution {
    public int threeSumSmaller(int[] nums, int target) {
        if (nums==null || nums.length<3) {
            return 0;
        }
        Arrays.sort(nums);
        int ans = 0;
        for (int i=0; i<nums.length; i++) {
            int newt = target - nums[i];
            int lo = i+1, hi = nums.length-1;
            while (lo < hi) {
                if (nums[lo] + nums[hi] < newt) {
                    ans += hi-lo;
                    lo++;
                } else {
                    hi--;
                }
            }
        }
        return ans;
    }
}