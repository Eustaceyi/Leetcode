class Solution {
    public boolean canJump(int[] nums) {
        int further=0;
        for (int i=0; i<nums.length; i++) {
            if (further >= i) {
                further = Math.max(further, i+nums[i]);
            }
        }
        return further >= nums.length-1;
    }
}