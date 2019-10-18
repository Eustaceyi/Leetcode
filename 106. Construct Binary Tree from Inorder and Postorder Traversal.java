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
    HashMap<Integer, Integer> in_pos = new HashMap<>();
    int[] inorder;
    int[] postorder;
    int po_idx;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.inorder = inorder;
        this.postorder = postorder;
        po_idx = postorder.length-1;
        build();
        return helper(0, po_idx);
    }
    
    private TreeNode helper(int st, int ed) {
        if (st > ed) {
            return null;
        }
        int nodeval = postorder[po_idx];
        po_idx--;
        TreeNode node = new TreeNode(nodeval);
        node.right = helper(in_pos.get(nodeval)+1, ed);
        node.left = helper(st, in_pos.get(nodeval)-1);
        return node;
    }
    
    private void build() {
        int idx = 0;
        for (int i : inorder) {
            in_pos.put(i, idx++);
        }
    }
}