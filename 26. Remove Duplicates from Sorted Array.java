class Solution {
    public int removeDuplicates(int[] nums) {
        int write = 0;
        for (int j = 1; j<nums.length; j++) {
            if (nums[j] != nums[write]) {
                nums[++write] = nums[j];
            }
        }
        return write+1;
    }
}