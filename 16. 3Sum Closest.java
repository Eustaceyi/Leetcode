class Solution {
    public int threeSumClosest(int[] nums, int target) {
        if (nums.length == 3) {
            return nums[0]+nums[1]+nums[2];
        }
        Arrays.sort(nums);
        int ret = nums[0] + nums[1] + nums[2];
        for (int i=0; i<nums.length-2; i++) {
            if (i == 0 || nums[i] != nums[i-1]) {
                int lo = i+1, hi = nums.length-1;
                while (lo < hi) {
                    int temp = nums[i] + nums[lo] + nums[hi];
                    if (temp == target) {
                        return temp;
                    }
                    if (Math.abs(target-temp) < Math.abs(target-ret)) {
                        ret = temp;
                        while (lo<hi && nums[lo] == nums[lo+1]) {lo++;}
                        while (lo<hi && nums[hi] == nums[hi-1]) {hi--;}
                    }
                    if (temp < target) {
                        lo++;
                    } else {
                        hi--;
                    }
                }
            }
        }
        return ret;
    }
}