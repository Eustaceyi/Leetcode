/**
 * O(n) time O(1) space, rotate to final position
 */
class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        int count = 0;
        for (int start=0; count<n; start++) {
            int curr = start;
            int prev = nums[start];
            while (true) {
                int next = (curr + k) % n;
                int temp = nums[next];
                nums[next] = prev;
                prev = temp;
                curr = next;
                count++;
                if (curr == start) {
                    break;
                }
            }
        }
    }
}

/**
 * reverse the whole array, and then reverse first part and second part
 * O(n) time O(1) space
 */
class Solution {
    public void rotate(int[] nums, int k) {
        reverse(nums, 0, nums.length-1);
        reverse(nums, 0, k % nums.length-1);
        reverse(nums, k % nums.length, nums.length-1);
    }
    private void reverse(int[] nums, int st, int ed) {
        while (st < ed) {
            int temp = nums[st];
            nums[st] = nums[ed];
            nums[ed] = temp;
            st++; ed--;
        }
    }
}