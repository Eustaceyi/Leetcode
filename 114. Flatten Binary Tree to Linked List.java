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
     * Time O(n)
     * Space O(1) constant
     * @param root
     */
    public void flatten(TreeNode root) {
        TreeNode right;
        while (root!=null) {
            if (root.left!=null) {
                right = root.right;
                TreeNode node = root.left;
                root.right = node;
                root.left = null;
                while (node.right!=null) {
                    node = node.right;
                }
                node.right = right;
            }
            root = root.right;
        }
    }
}