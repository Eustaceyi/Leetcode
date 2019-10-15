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
     * Recursion to pick a root and genreate all possible trees,
     * then append it to the list
     * Time O(4^n/(n^0.5)) since generate a tree with n nodes are Cn = Sum(Ci * Cn-i) and we are generating n times
     * Space also O(4^n/(n^0.5))
     * @param n
     * @return
     */
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new LinkedList<TreeNode>();
        }
        return generate(1,n);
    }
    
    private List<TreeNode> generate(int st, int ed) {
        List<TreeNode> trees = new LinkedList<TreeNode>();
        if (st > ed) {
            trees.add(null);
            return trees;
        }
        
        for (int i=st;i<=ed;i++) {
            List<TreeNode> leftTrees = generate(st, i-1);
            List<TreeNode> rightTrees = generate(i+1, ed);
            for (TreeNode l : leftTrees) {
                for (TreeNode r : rightTrees) {
                    TreeNode treeRoot = new TreeNode(i);
                    treeRoot.left = l;
                    treeRoot.right = r;
                    trees.add(treeRoot);
                }
            }
        }
        return trees;
    }
}