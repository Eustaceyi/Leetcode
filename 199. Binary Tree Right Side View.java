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
     * Iterative method, level order traversal
     * Time O(n) since we traverse all nodes
     * Space O(n)
     * @param root
     * @return
     */
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return new LinkedList<>();
        }
        List<TreeNode> l = new LinkedList<>();
        List<Integer> ans = new LinkedList<>();
        l.add(root);
        while (l.size() != 0) {
            List<TreeNode> temp = new LinkedList<>();
            for (TreeNode n : l) {
                if (n.left != null) {
                    temp.add(n.left);
                }
                if (n.right != null) {
                    temp.add(n.right);
                }
            }
            ans.add(l.get(l.size()-1).val);
            l = temp;
        }
        return ans;
    }
}
/**
 * Recursion method, key point is we add into ans list the first time we meet
 * a level, and then go deeper
 * Time O(n) we may need to traverse all node
 * Space O(height)
 */
class Solution {
    List<Integer> ans;
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return new LinkedList<>();
        }
        ans = new LinkedList<>();
        dfsHelper(root, 0);
        return ans;
    }
    private void dfsHelper(TreeNode root, int level) {
        if (root == null) {
            return;
        }
        if (level == ans.size()) {
            ans.add(root.val);
        }
        dfsHelper(root.right, level+1);
        dfsHelper(root.left, level+1);
    }
}