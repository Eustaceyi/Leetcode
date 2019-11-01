class Solution {
    public void moveZeroes(int[] nums) {
        if (nums==null || nums.length==0) return;
        int write = 0;
        for (int i=0; i<nums.length; i++) {
            if (nums[i]!=0) {
                nums[write++] = nums[i];
            }
        }
        while (write < nums.length) {
            nums[write++] = 0;
        }
    }
}