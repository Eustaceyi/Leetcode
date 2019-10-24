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
    public int longestUnivaluePath(TreeNode root) {
        ans = 0;
        helper(root);
        return ans;
    }
    private int helper(TreeNode root) {
        if (root==null) return 0;
        int left = helper(root.left);
        int right = helper(root.right);
        int thisLeft=0, thisRight=0;
        if (root.left!=null && root.val == root.left.val){
            thisLeft = left + 1;
        }
        if (root.right!=null && root.val==root.right.val) {
            thisRight = right + 1;
        }
        ans = Math.max(ans, thisRight+thisLeft);
        return Math.max(thisLeft, thisRight);
    }
}