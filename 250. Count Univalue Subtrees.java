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
    int ans;
    public int countUnivalSubtrees(TreeNode root) {
        ans=0;
        helper(root);
        return ans;
    }
    private boolean helper(TreeNode node) {
        if (node == null) {
            return true;
        }
        boolean left = helper(node.left);
        boolean right = helper(node.right);
        if (left && right) {
            if ((node.left==null || node.left.val == node.val) && (node.right==null || node.right.val==node.val)) {
                ans++;
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
}

class Solution {
    int ans;
    public int countUnivalSubtrees(TreeNode root) {
        ans=0;
        helper(root, 0);
        return ans;
    }
    private boolean helper(TreeNode node, int parVal) {
        if (node==null) {
            return true;
        }
        boolean left = helper(node.left, node.val);
        boolean right = helper(node.right, node.val);
        if (!left || !right) {
            return false;
        }
        ans++;
        return node.val == parVal;
    }
}