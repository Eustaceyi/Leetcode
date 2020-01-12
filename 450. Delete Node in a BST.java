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
    public TreeNode deleteNode(TreeNode root, int key) {
        // find the node
        TreeNode node = root, prev = null;
        boolean fromLeft = true;
        while (node != null) {
            if (node.val == key) {
                break;
            } else if (node.val > key) {
                prev = node;
                node = node.left;
                fromLeft = true;
            } else {
                prev = node;
                node = node.right;
                fromLeft = false;
            }
        }
        // check if the tree contians the key
        if (node == null) {
            return root;
        }
        // this node have no child
        if (node.left==null && node.right==null) {
            if (prev != null) {
                if (fromLeft) {
                    prev.left = null;
                    return root;
                } else {
                    prev.right = null;
                    return root;
                }
            } else {
                return null;
            }
        } else if (node.left == null) { // only right child
            if (prev != null) {
                if (fromLeft) {
                    prev.left = node.right;
                    node.right = null;
                    return root;
                } else {
                    prev.right = node.right;
                    node.right = null;
                    return root;
                }
            } else {
                TreeNode newRoot = node.right;
                node.right = null;
                return newRoot;
            }
        } else if (node.right == null) { // only left child
            if (prev != null) {
                if (fromLeft) {
                    prev.left = node.left;
                    node.left = null;
                    return root;
                } else {
                    prev.right = node.left;
                    node.left = null;
                    return root;
                }
            } else {
                TreeNode newRoot = node.left;
                node.left = null;
                return newRoot;
            }
        } else { // both child exists
            TreeNode succ = node.right;
            TreeNode succprev = node;
            while (succ.left != null) {
                succprev = succ;
                succ = succ.left;
            }
            if (succprev != node) {
                succprev.left = succ.right;
            } else {
                succprev.right = succ.right;
            }
            succ.left = node.left;
            succ.right = node.right;
            node.left = null;
            node.right = null;
            if (prev == null) {
                return succ;
            } else {
                if (fromLeft) {
                    prev.left = succ;
                } else {
                    prev.right = succ;
                }
                return root;
            }
        }
    }
}