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
 * Time O(n) all node is traversed once
 * Space O(n) the worst case the set and the stack will goes to n
 */
class Solution {
    HashSet<Integer> toDel;
    List<TreeNode> ans;
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        toDel = new HashSet<>();
        for (int i : to_delete) {
            toDel.add(i);
        }
        ans = new LinkedList<>();
        helper(root, null, true);
        return ans;
    }
    private void helper(TreeNode root, TreeNode par, boolean isLeft) {
        if (root == null) {
            return;
        }
        if (!toDel.contains(root.val)) {
            if (par==null) {
                ans.add(root);
            }
            helper(root.left, root, true);
            helper(root.right, root, false);
        } else {
            if (par != null) {
                if (isLeft) {
                    par.left = null;
                } else {
                    par.right = null;
                }
            }
            TreeNode left = root.left;
            TreeNode right = root.right;
            root.left = null;
            root.right = null;
            helper(left, null, true);
            helper(right, null, false);
        }
    }
}