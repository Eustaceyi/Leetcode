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
     * Key point is to split the inorder array by finding the left subtree and the right subtree
     * notice that the preorder is root -> left -> right, so we can use this by using global variable to get rid of array copy
     * and we can first put all index and value pair into a hashmap, this can boost up looking up
     */
    private int pre_idx = 0;
    private int[] preorder;
    private int[] inorder;
    private HashMap<Integer, Integer> map = new HashMap<>();
    
    private TreeNode helper(int instart, int inend) {
        if (instart == inend) {
            return null;
        }
        int rootval = preorder[pre_idx];
        TreeNode root = new TreeNode(rootval);
        pre_idx++;
        int index = map.get(rootval);
        root.left = helper(instart, index);
        root.right = helper(index+1, inend);
        return root;
    }
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        this.inorder = inorder;
        int idx = 0;
        for (int item : inorder) {
            map.put(item, idx);
            idx++;
        }
        return helper(0, inorder.length);
    }
}