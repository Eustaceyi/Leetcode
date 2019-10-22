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
    public boolean isSubtree(TreeNode s, TreeNode t) {
        return traverse(s, t);
    }
    private boolean check(TreeNode s, TreeNode t) {
        if (s == null && t==null) {
            return true; 
        } 
        if (s == null || t == null) {
            return false;
        }
        return (s.val == t.val) && check(s.left, t.left) && check(s.right, t.right);
    }
    private boolean traverse(TreeNode s, TreeNode t) {
        return s != null && (check(s,t) || traverse(s.left, t) || traverse(s.right, t));
    }
}

class Solution {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null || t == null) {
            return false;
        }
        Deque<TreeNode> dq = new LinkedList<>();
        dq.offer(s);
        while (!dq.isEmpty()) {
            TreeNode node = dq.poll();
            if (node.val == t.val) {
                if (check(node, t)) {
                    return true;
                }
            }
            if (node.left != null) {
                dq.offer(node.left);
            }
            if (node.right != null) {
                dq.offer(node.right);
            }
        }
        return false;
    }
    private boolean check(TreeNode s, TreeNode t) {
        if (s == null && t==null) {
            return true; 
        } 
        if (s == null || t == null) {
            return false;
        }
        return (s.val == t.val) && check(s.left, t.left) && check(s.right, t.right);
    }
}