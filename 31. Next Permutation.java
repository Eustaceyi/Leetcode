class Solution {
    /**
     * First find out the first desecending seq from right to left,
     * then find out the closest larger element, swap them
     * then reverse the right part
     * Time O(n)
     * Space O(1)
     */
    public void nextPermutation(int[] nums) {
        int i;
        for (i = nums.length-2; i >= 0; i--) {
            if (nums[i] < nums[i+1]) {
                break;
            }
        }
        if (i >= 0) {
            int j = nums.length - 1;
            while (j > i && nums[j] <= nums[i]) {
                j--;
            }
            int temp = nums[j];
            nums[j] = nums[i];
            nums[i] = temp;
        }
        int l = i+1, r = nums.length-1;
        while (l<r) {
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
            l++; r--;
        }
    }
}