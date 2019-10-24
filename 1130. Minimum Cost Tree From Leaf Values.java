/**
 * Keep a monotonic stack and when we remove smaller items the cost is smaller of the next larger from and the next larger from right
 * and when we iterate all element we pop from stack and add to the answer
 * Time O(n) since we put each element into stack once
 * Space O(n) worst case we may put all element into stack
 */
class Solution {
    public int mctFromLeafValues(int[] arr) {
        Deque<Integer> stack = new LinkedList<>();
        stack.push(Integer.MAX_VALUE);
        int ans = 0;
        for (int i : arr) {
            while (stack.peek() < i) {
                int temp = stack.pop();
                ans += temp * (stack.peek() > i ? i: stack.peek());
            }
            stack.push(i);
        }
        while (stack.size()>2) {
            ans += stack.pop() * stack.peek();
        }
        return ans;
    }
}