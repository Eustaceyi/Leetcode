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
    public int kthSmallest(TreeNode root, int k) {
        Deque<TreeNode> dq = new ArrayDeque<>();
        
        if (root == null) {
            return 0;
        }
        TreeNode curr = root;
        while (curr != null || !dq.isEmpty()) {
            while (curr != null) {
                dq.add(curr);
                curr = curr.left;
            }
            curr = dq.pollLast();
            k--;
            if (k==0) break;
            curr = curr.right;
        }
        return curr.val;
    }
}