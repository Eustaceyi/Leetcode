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
    public int closestValue(TreeNode root, double target) {
        int clmax = Integer.MIN_VALUE, clmin = Integer.MAX_VALUE;
        while (root != null) {
            if ((double)root.val > target) {
                clmax = root.val;
                root = root.left;
            } else if ((double)root.val < target) {
                clmin = root.val;
                root = root.right;
            } else {
                return root.val;
            }
        }
        if (clmax == Integer.MIN_VALUE) {
            return clmin;
        } else if (clmin == Integer.MAX_VALUE) {
            return clmax;
        } else {
            return (target-clmin > clmax-target) ? clmax : clmin;
        }
    }
}