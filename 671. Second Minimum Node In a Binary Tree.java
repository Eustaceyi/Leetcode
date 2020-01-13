/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int findSecondMinimumValue(TreeNode root) {
        if (root == null) {
            return -1;
        }
        Deque<TreeNode> dq = new ArrayDeque<>();
        dq.offer(root);
        Integer second = null;
        int min = root.val;
        while (!dq.isEmpty()) {
            TreeNode node = dq.poll();
            if (node.val == min) {
                if (node.left != null) {
                    dq.offer(node.left);
                    dq.offer(node.right);
                }
            } else {
                if (second == null) {
                    second = node.val;
                } else {
                    second = Math.min(second, node.val);
                }
            }
        }
        return second == null ? -1 : second;
    }
}