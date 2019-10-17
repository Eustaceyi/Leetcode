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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Deque<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        boolean rev = false;
        while (!q.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            Deque<TreeNode> next = new ArrayDeque<>();
            for (TreeNode node : q) {
                temp.add(node.val);
                if (node.left != null) {
                    next.add(node.left);
                }
                if (node.right != null) {
                    next.add(node.right);
                }
            }
            if (rev) {
                Collections.reverse(temp);
            }
            rev = !rev;
            ans.add(temp);
            q = next;
        }
        return ans;
    }
}