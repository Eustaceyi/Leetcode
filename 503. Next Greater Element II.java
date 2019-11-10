/**
 * Loop twice to find out the circular NGE
 * Time O(n)
 * Spcae O(n)
 */
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Arrays.fill(res, -1);
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i=0; i<n*2-1; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i%n]) {
                int temp = stack.pop();
                res[temp] = nums[i%n];
            }
            stack.push(i%n);
        }
        return res;
    }
}