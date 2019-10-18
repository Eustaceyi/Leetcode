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
     * Recursion method O(n) time O(h) height of tree
     * @param root
     * @return
     */
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right==null) {
            return 1;
        }
        int minDep = Integer.MAX_VALUE;
        if (root.left != null) {
            minDep = Math.min(minDep, minDepth(root.left));
        }
        if (root.right != null) {
            minDep = Math.min(minDep, minDepth(root.right));
        }
        return minDep+1;
    }
}

class Solution {
    /**
     * DFS solution, O(n) time O(n) space
     * @param root
     * @return
     */
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int minDep = Integer.MAX_VALUE;
        LinkedList<Pair<TreeNode, Integer>> stack = new LinkedList<>();
        stack.add(new Pair(root, 1));
        while (!stack.isEmpty()) {
            Pair<TreeNode, Integer> p = stack.pollLast();
            root = p.getKey();
            int currdep = p.getValue();
            if (root.left == null && root.right == null) {
                minDep = Math.min(minDep, currdep);
            }
            if (root.left != null) {
                stack.add(new Pair(root.left, currdep+1));
            }
            if (root.right != null) {
                stack.add(new Pair(root.right, currdep+1));
            }
        }
        return minDep;
   }
}

class Solution {
    /**
     * BFS solution, O(n) time O(n) space
     * @param root
     * @return
     */
    public int minDepth(TreeNode root) {
      LinkedList<Pair<TreeNode, Integer>> queue = new LinkedList<>();
      if (root == null) {
        return 0;
      }
      else {
        queue.add(new Pair(root, 1));
      }
  
      int current_depth = 0;
      while (!queue.isEmpty()) {
        Pair<TreeNode, Integer> current = queue.poll();
        root = current.getKey();
        current_depth = current.getValue();
        if ((root.left == null) && (root.right == null)) {
          break;
        }
        if (root.left != null) {
          queue.add(new Pair(root.left, current_depth + 1));
        }
        if (root.right != null) {
          queue.add(new Pair(root.right, current_depth + 1));
        }
      }
      return current_depth;
    }
  }