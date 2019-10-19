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
 * BFS solution with deque
 */
import javafx.util.Pair;
class Solution {
    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int sum = 0;
        Deque<Pair<TreeNode, Integer>> dq = new ArrayDeque<>();
        dq.add(new Pair(root, root.val));
        while (!dq.isEmpty()) {
            Pair<TreeNode, Integer> p = dq.poll();
            TreeNode node = p.getKey();
            int curr = p.getValue();
            if (node.left==null && node.right==null) {
                sum += curr;
            }
            if (node.left!=null) {
                dq.add(new Pair(node.left, curr*10+node.left.val));
            }
            if (node.right!=null) {
                dq.add(new Pair(node.right, curr*10+node.right.val));
            }
        }
        return sum;
    }
}

/**
 * DFS recursion solution
 * Time O(n) we traverse all node once
 * Space O(height) the stack may goes as height of tree
 */
class Solution {
    int res;
    public int sumNumbers(TreeNode root) {
        if (root==null) {
            return 0;
        }
        res = 0;
        dfs(root, 0);
        return res;
    }
    private void dfs(TreeNode root, int curr) {
        if (root==null) {
            return;
        }
        curr = curr * 10 + root.val;
        if (root.left==null && root.right==null) {
            res += curr;
            curr /= 10;
            return;
        }
        if (root.left!=null) {
            dfs(root.left, curr);
        }
        if (root.right!=null) {
            dfs(root.right, curr);
        }
        curr /= 10;
    }
}