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
     * recursion method, consider that we should build from the left most and 
     * build the new tree bottom up
     * Time O(n) since this tree is never a balanced tree
     * Space O(n) since the stack may goes O(n) long
     * @param root
     * @return
     */
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if (root==null) {
            return null;
        }
        if (root.left == null) {
            return root;
        }
        TreeNode newRoot = upsideDownBinaryTree(root.left);
        root.left.left = root.right;
        root.left.right = root;
        root.left=null;
        root.right=null;
        return newRoot;
    }
}

class Solution {
    /**
     * Iterative method 
     * Time O(n)
     * Space O(n)
     * @param root
     * @return
     */
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        Deque<TreeNode> dq = new ArrayDeque<>();
        if (root == null || root.left == null) {
            return root;
        }
        while (root != null) {
            dq.add(root);
            root = root.left;
        }
        TreeNode newRoot = dq.pollLast();
        while (!dq.isEmpty()) {
            TreeNode node = dq.pollLast();
            node.left.left = node.right;
            node.left.right = node;
            node.left = null;
            node.right = null;
        }
        return newRoot;
    }
}