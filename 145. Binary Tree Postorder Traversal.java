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
 * recursion method
 */
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        helper(root, ans);
        return ans;
    }
    private void helper(TreeNode root, List<Integer> ans) {
        if (root != null) {
            helper(root.left, ans);
            helper(root.right,ans);
            ans.add(root.val);
        }
    }
}

/**
 * Iteration method of postorder
 * we first go leftmost, and when we are getting there, we put right -> curr into the deque
 * and then we start to poll from deque,
 * as we are polling, if we encounter a node that its right is at the last of deque,
 * we save this node and go to its right,
 * then we can achieve left -> right -> middle
 */
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        Deque<TreeNode> dq = new ArrayDeque<>();
        List<Integer> ans = new LinkedList<>();
        if (root == null) {
            return ans;
        }
        TreeNode curr = root;
        while (curr != null || !dq.isEmpty()) {
            while (curr != null) {
                if (curr.right != null) {
                    dq.add(curr.right);
                }
                dq.add(curr);
                curr = curr.left;
            }
            curr = dq.pollLast();
            
            if (!dq.isEmpty() && dq.peekLast() == curr.right) {
                dq.pollLast();
                dq.add(curr);
                curr = curr.right;
            } else {
                ans.add(curr.val);
                curr = null;
            }
        }
        return ans;
    }
}