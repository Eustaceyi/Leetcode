/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class BSTIterator {
    private Deque<TreeNode> dq;
    
    public BSTIterator(TreeNode root) {
        dq = new ArrayDeque<>();
        while (root != null) {
            dq.add(root);
            root = root.left;
        }
    }
    
    /** @return the next smallest number */
    public int next() {
        TreeNode node = dq.pollLast();
        TreeNode toRet = node;
        if (node.right != null) {
            node = node.right;
            while (node != null) {
                dq.add(node);
                node = node.left;
            }
        }
        return toRet.val;
    }
    
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !dq.isEmpty();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */