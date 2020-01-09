/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
/**
 * O(h) solution O(1) space
 * key point:
 * 1. if we find the curr is larger than p, we go left and keep record of curr
 * 2. if we find the curr is smaller or equal to p, we go right since the successor may
 *    come above p or under p
 */
class Solution {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {

        TreeNode candidate = null;
        TreeNode cur = root;

        while (cur != null) {
            if (cur.val > p.val) {
                candidate = cur;
                cur = cur.left;
            } else {
                // cur.val <= p.val
                cur = cur.right;
            }
        }

        return candidate;
    }
}