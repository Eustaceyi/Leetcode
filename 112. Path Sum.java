/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
import javafx.util.Pair;
class Solution {
    /**
     * recursion method, check all nodes
     * Time O(n)
     * Space O(height of tree)
     * @param root
     * @param sum
     * @return
     */
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        if (root.left == null & root.right == null) {
            return sum == root.val ? true : false;
        }
        return hasPathSum(root.left, sum-root.val) || hasPathSum(root.right, sum-root.val);
    }
}

class Solution {
    /**
     * BFS solution, using Pair for sum
     * @param root
     * @param sum
     * @return
     */
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        Deque<Pair<TreeNode, Integer>> q = new ArrayDeque<>();
        q.add(new Pair(root, 0));
        while (!q.isEmpty()) {
            Pair<TreeNode, Integer> p = q.poll();
            TreeNode node = p.getKey();
            int currsum = p.getValue();
            if (node.left == null && node.right == null && currsum + node.val == sum) {
                return true;
            }
            if (node.left != null) {
                q.add(new Pair(node.left, currsum+node.val));
            }
            if (node.right != null) {
                q.add(new Pair(node.right, currsum+node.val));
            }
        }
        return false;
    }
}

class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        Deque<Pair<TreeNode, Integer>> stack = new ArrayDeque<>();
        stack.add(new Pair(root, 0));
        while (!stack.isEmpty()) {
            Pair<TreeNode, Integer> p = stack.pollLast();
            TreeNode node = p.getKey();
            int currsum = p.getValue();
            if (node.left == null && node.right == null && currsum + node.val == sum) {
                return true;
            }
            if (node.left != null) {
                stack.add(new Pair(node.left, currsum+node.val));
            }
            if (node.right != null) {
                stack.add(new Pair(node.right, currsum+node.val));
            }
        }
        return false;
    }
}