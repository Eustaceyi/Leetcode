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
    /**
     * use height count for helper function,
     * if there is unbalance, return -1 immedately, 
     * this could help with early stop
     * @param root
     * @return
     */
    public boolean isBalanced(TreeNode root) {
        return height(root) != -1;
    }
    
    private int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = height(root.left);
        int right = height(root.right);
        if (left == -1 || right == -1) {
            return -1;
        }
        if (Math.abs(left - right) > 1) {
            return -1;
        }
        return Math.max(left, right)+1;
    }
}