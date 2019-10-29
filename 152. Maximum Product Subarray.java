/**
 * keep track of currmax and currmin and determine if the curr number is pos or neg
 */
class Solution {
    public int maxProduct(int[] nums) {
        if (nums==null || nums.length==0) {
            return 0;
        }
        int currmax=nums[0], currmin=nums[0], ans=nums[0];
        for (int i=1; i< nums.length; i++) {
            int temp = nums[i];
            if (temp > 0) {
                currmax = Math.max(temp * currmax, temp);
                currmin = Math.min(temp * currmin, temp);
                ans = Math.max(currmax, ans);
            } else {
                int tempmin = Math.min(temp * currmax, temp);
                int tempmax = Math.max(temp * currmin, temp);
                currmax = tempmax;
                currmin = tempmin;
                ans = Math.max(currmax, ans);
            }
        }
        return ans;
    }
}