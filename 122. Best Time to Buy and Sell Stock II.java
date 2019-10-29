class Solution {
    /**
     * similiar to monotonic stack
     * Time O(n) one pass
     * Space O(n) stack may goes to n
     */
    public int maxProfit(int[] prices) {
        Deque<Integer> stack = new LinkedList<>();
        stack.push(Integer.MAX_VALUE);
        int ans = 0;
        for (int i : prices) {
            if (i > stack.peek()) {
                ans += i - stack.pop();
            }
            stack.push(i);
        }
        return ans;
    }
}