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
 * dfs without saving nodes, time O(n) space O(h)
 */
class Solution {
    TreeNode ans;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        tt(root, p, q);
        return ans;
    }
    private boolean tt(TreeNode node, TreeNode p, TreeNode q) {
        if (node == null) {
            return false;
        }
        int left = tt(node.left, p, q) ? 1 : 0;
        int right = tt(node.right, p, q) ? 1 : 0;
        int mid = (node==p || node==q) ? 1 : 0;
        if (left+right+mid >= 2) {
            ans = node;
        }
        return (left+right+mid) >= 1;
    }
}
/**
 * dfs with saving path, time O(n) space O(height)
 */
class Solution {
    List<TreeNode> lp, lq;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p, q, new ArrayList<>());
        for (int i=0;i<Math.min(lp.size(), lq.size());i++) {
            if (lp.get(i) != lq.get(i)) {
                return lp.get(i-1);
            }
        }
        return lp.get(Math.min(lp.size(), lq.size())-1);
    }
    private void dfs(TreeNode node, TreeNode p, TreeNode q, List<TreeNode> temp) {
        if (node == null) {
            return;
        }
        temp.add(node);
        if (node == p) {
            lp = new ArrayList(temp);
        }
        if (node == q) {
            lq = new ArrayList(temp);
        }
        dfs(node.left, p, q, temp);
        dfs(node.right, p, q, temp);
        temp.remove(temp.size()-1);
    }
}