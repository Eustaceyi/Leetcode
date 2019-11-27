import javafx.util.Pair;
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
    public List<List<Integer>> verticalOrder(TreeNode root) {
        if (root==null) {
            return new LinkedList<>();
        }
        LinkedList<List<Integer>> ans = new LinkedList<>();
        ans.add(new ArrayList<>());
        int minIndex = 0;
        int maxIndex = 0;
        Queue<Pair<TreeNode, Integer>> q = new ArrayDeque<>();
        q.offer(new Pair(root, 0));
        while (!q.isEmpty()) {
            Pair<TreeNode, Integer> p = q.poll();
            TreeNode curr = p.getKey();
            int pos = p.getValue();
            if (pos < minIndex) {
                minIndex = pos;
                ans.addFirst(new ArrayList<>());
            }
            if (pos > maxIndex) {
                maxIndex = pos;
                ans.addLast(new ArrayList<>());
            }
            ans.get(pos-minIndex).add(curr.val);
            if (curr.left != null) {
                q.offer(new Pair(curr.left, pos-1));
            }
            if (curr.right != null) {
                q.offer(new Pair(curr.right, pos+1));
            }
        }
        return ans;
    }
}