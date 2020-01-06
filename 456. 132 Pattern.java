/**
 * use stack and min array to keep track of the 132 pattern
 * Time O(n)
 * Space O(n)
 */
class Solution {
    public boolean find132pattern(int[] nums) {
        if (nums.length < 3) {
            return false;
        }
        int n = nums.length;
        int[] min = new int[n];
        min[0] = nums[0];
        // this is for keeping the min array
        for (int i=1; i<n; i++) {
            min[i] = Math.min(min[i-1], nums[i]);
        }
        Deque<Integer> stack = new ArrayDeque<>();
        // this stack is for keep tracking of the items behind curr
        for (int i=n-1; i>=0; i--) {
            // if we found the top item in stack is smaller than min of curr pos,
            // which means that the stack top is smaller than the smaller one ahead 
            // of curr pos, we should pop it
            while (!stack.isEmpty() && stack.peek() <= min[i]) {
                stack.pop();
            } 
            // if the stack top is larger than min and smaller than curr pos
            if (!stack.isEmpty() && stack.peek() < nums[i]) {
                return true;
            }
            stack.push(nums[i]);
        }
        return false;
    }
}