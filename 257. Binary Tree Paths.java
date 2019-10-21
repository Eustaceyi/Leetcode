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
    List<String> ans;
    public List<String> binaryTreePaths(TreeNode root) {
        ans = new LinkedList<>();
        dfs(root, "");
        return ans;
    }
    private void dfs(TreeNode root, String s) {
        if (root==null) {
            return;
        }
        s += Integer.toString(root.val);
        if (root.left==null && root.right==null) {
            ans.add(s);
        } else {
            s += "->";
            dfs(root.left, s);
            dfs(root.right, s);
        }
        
    }
}