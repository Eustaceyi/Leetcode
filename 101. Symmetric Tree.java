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
     * recursive method
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSym(root.left, root.right);
    }
    private boolean isSym(TreeNode l, TreeNode r) {
        if (l==null && r==null) {
            return true;
        } else if (l==null || r==null) {
            return false;
        } else {
            return isSym(l.left, r.right) && isSym(l.right, r.left) && l.val==r.val;
        }
    }

    /**
     * iterative method, notice ArrayDeque in java don't allow adding null as element, use LinkedList instead
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        Deque<TreeNode> q = new LinkedList<>();
        q.add(root.left);
        q.add(root.right);
        while (!q.isEmpty()) {
            TreeNode l = q.poll();
            TreeNode r = q.poll();
            if (l==null && r==null) {
                continue;
            } else if (l==null || r==null) {
                return false;
            } else if (l.val != r.val) {
                return false;
            } else {
                q.add(l.left);
                q.add(r.right);
                q.add(l.right);
                q.add(r.left);
            }
        }
        return true;
    }
}