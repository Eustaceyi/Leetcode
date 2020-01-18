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
 * we serialize each subtree by preorder \ postorder
 * (here we cannot use inorder because it will generate same serial)
 * and we check if there is same tree
 */
class Solution {
    private HashMap<String, Integer> count;
    private List<TreeNode> ans;
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        count = new HashMap<>();
        ans = new ArrayList<>();
        generate(root);
        return ans;
    }
    
    private String generate(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        if (root == null) {
            return "#";
        }
        sb.append(root.val);
        sb.append(',');
        sb.append(generate(root.left));
        sb.append(',');
        sb.append(generate(root.right));
        String s = sb.toString();
        count.put(s, count.getOrDefault(s, 0)+1);
        if (count.get(s) == 2) {
            ans.add(root);
        }
        return s;
    }
}