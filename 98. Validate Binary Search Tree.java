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
     * recursion checking all subtrees
     * Time O(n)
     * Space O(n)
     * also could use inorder traversal to check if it is sorted
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {
        return isValid(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    
    private boolean isValid(TreeNode root, long lb, long ub) {
        if (root == null) {
            return true;
        }
        boolean left = isValid(root.left, lb, (long) root.val);
        boolean right = isValid(root.right, (long) root.val, ub);
        return left && right && root.val > lb && root.val < ub;
    }
}