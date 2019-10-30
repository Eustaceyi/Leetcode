/**
 * careful about integer overflow issue
 */
class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> ans = new ArrayList<>();
        if (nums==null || nums.length==0) {
            if (upper == lower) {
                ans.add(String.valueOf(upper));
                return ans;
            } else {
                ans.add(String.valueOf(lower) + "->" + String.valueOf(upper));
                return ans;
            }
        }
        long temp = (long)nums[0] - (long)lower;
        if (temp > 0L) {
            if (temp == 1L) {
                ans.add(String.valueOf(lower));
            } else {
                ans.add(String.valueOf(lower) + "->" + String.valueOf(nums[0]-1));
            }
        }
        for (int i=1; i<nums.length; i++) {
            temp = (long)nums[i] - (long)nums[i-1];
            if (temp > 1L) {
                if (temp == 2L) {
                    ans.add(String.valueOf(nums[i-1]+1));
                } else {
                    ans.add(String.valueOf(nums[i-1]+1) + "->" + String.valueOf(nums[i]-1));
                }
            }
        }
        temp = (long)upper - (long)nums[nums.length-1];
        if (temp > 0L) {
            if (temp == 1L) {
                ans.add(String.valueOf(upper));
            } else {
                ans.add(String.valueOf(nums[nums.length-1]+1) + "->" + String.valueOf(upper));
            }
        }
        return ans;
    }
}