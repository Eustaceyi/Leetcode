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
     * Recursive method of inorder traversal
     * @param root
     * @return List<Integer>
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<Integer>();
        inorder(root, ans);
        return ans;
    }
    private void inorder(TreeNode node, List<Integer> ans) {
        if (node == null) {
            return;
        }
        inorder(node.left, ans);
        ans.add(node.val);
        inorder(node.right, ans);
    }

    /**
     * Iterative method of inorder traversal
     * @param root
     * @return List<Integer>
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<Integer>();
        Stack<TreeNode> s = new Stack<>();
        TreeNode curr = root;
        while (curr != null || !s.empty()) {
            while (curr != null) {
                s.push(curr);
                curr = curr.left;
            }
            curr = s.pop();
            ans.add(curr.val);
            curr = curr.right;
        }
        return ans;
    }

    /**
     * Morris Traversal O(n) time, O(1) space
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<Integer>();
        TreeNode curr = root, pre;
        while (curr != null) {
            if (curr.left == null) {
                ans.add(curr.val);
                curr = curr.right;
            } else {
                pre = curr.left;
                while (pre.right != null) {
                    pre = pre.right;
                }
                pre.right = curr;
                TreeNode temp = curr;
                curr = curr.left;
                temp.left = null;
            }
        }
        return ans;
    }
}