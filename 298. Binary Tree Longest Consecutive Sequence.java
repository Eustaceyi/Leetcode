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
    public int longestConsecutive(TreeNode root) {
        ans = 0;
        helper(root, null, 0);
        return ans;
    }
    private void helper(TreeNode root, TreeNode parent, int len) {
        if (root==null) {return;}
        len = (parent!=null && root.val == parent.val+1) ? len+1 : 1;
        ans = Math.max(len, ans);
        helper(root.left, root, len);
        helper(root.right, root, len);
    }
}