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
    int level;
    public int countNodes(TreeNode root) {
        int leftLevel=0, rightLevel=0;
        TreeNode node = root;
        while (node != null) {
            leftLevel++;
            node = node.left;
        }
        node = root;
        while (node != null) {
            rightLevel++;
            node = node.right;
        }
        if (leftLevel == rightLevel) {
            return (int)Math.pow(2, leftLevel) - 1;
        }
        level = rightLevel;
        int lo=0, hi=(int)Math.pow(2, level)-1;
        while (lo <= hi) {
            int mid = (hi-lo)/2 + lo;
            if (find(root, mid) && !find(root, mid+1)) {
                return (int)Math.pow(2, level) + mid;
            } else if (find(root, mid) && find(root, mid+1)) {
                lo = mid+1;
            } else {
                hi = mid-1;
            }
        }
        return 0;
    }
    private boolean find(TreeNode root, int index) {
        int l = level;
        while (l > 0) {
            int curr = (int)Math.pow(2, l-1);
            if (index >= curr) {
                root = root.right;
                index -= curr;
            } else {
                root = root.left;
            }
            l--;
        }
        return (root != null);
    }
}