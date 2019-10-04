class Solution {
    public int removeElement(int[] nums, int val) {
        int w = 0;
        for (int r = 0; r<nums.length;r++) {
            if (nums[r] != val) {
                nums[w++] = nums[r];
            }
        }
        return w;
    }
}