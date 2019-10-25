/**
 * keep track of this step max and next step max,
 * we try to find the max of each step,
 * and we check one by one in each step
 * Time O(n)
 * Space O(1)
 */
class Solution {
    public int jump(int[] nums) {
        if (nums==null || nums.length==0) {
            return 0;
        }
        int n = nums.length;
        int thismax=0, nextmax=0, step=0;
        for (int i=0; i<n-1; i++) {
            nextmax = Math.max(nextmax, i+nums[i]);
            if (i == thismax) {
                thismax = nextmax;
                step++;
            }
        }
        return step;
    }
}