import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;

import javax.swing.tree.TreeNode;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    public boolean findTarget(TreeNode root, int k) {
        HashSet<Integer> set = new HashSet<>();
        Deque<TreeNode> dq = new ArrayDeque<>();
        if (root==null) {
            return false;
        }
        dq.offer(root);
        while (!dq.isEmpty()) {
            TreeNode node = dq.poll();
            if (set.contains(node.val)) {
                return true;
            }
            set.add(k-node.val);
            if (node.left!=null) {
                dq.offer(node.left);
            }
            if (node.right!=null) {
                dq.offer(node.right);
            }
        }
        return false;
    }
}

class Solution {
    HashSet<Integer> set;
    public boolean findTarget(TreeNode root, int k) {
        set = new HashSet<>();
        return helper(root, k);
    }
    private boolean helper(TreeNode root, int k) {
        if (root == null) {
            return false;
        }
        if (set.contains(root.val)) {
                return true;
        }
        set.add(k-root.val);
        return helper(root.left, k) || helper(root.right, k);
    }
}

class Solution {
    List<Integer> l;
    public boolean findTarget(TreeNode root, int k) {
        l = new ArrayList<>();
        helper(root);
        int lo=0, hi=l.size()-1;
        while (lo<hi) {
            if (l.get(lo)+l.get(hi)==k) {
                return true;
            } else if (l.get(lo)+l.get(hi) < k) {
                lo++;
            } else {
                hi--;
            }
        }
        return false;
    }
    private void helper(TreeNode root) {
        if (root == null) {
            return;
        }
        helper(root.left);
        l.add(root.val);
        helper(root.right);
    }
}