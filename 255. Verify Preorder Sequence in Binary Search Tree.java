class Solution {
    /**
     * Using stack for mimicing the inorder traversal,
     * if we have poped item out of the stack,
     * which means that there will not be a smaller item than it
     * Time O(n) Space O(n)
     * @param preorder
     * @return
     */
    public boolean verifyPreorder(int[] preorder) {
        Deque<Integer> stack = new ArrayDeque<>();
        int low = Integer.MIN_VALUE;
        for (int i : preorder) {
            if (i < low) {
                return false;
            }
            while (!stack.isEmpty() && stack.peek() < i) {
                low = stack.pop();
            }
            stack.push(i);
        }
        return true;
    }
}