/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class MyNode {
    public TreeNode node;
    public int level;
    public int pos;
    public MyNode(TreeNode node, int level, int pos) {
        this.node = node;
        this.level = level;
        this.pos = pos;
    }
}

class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<MyNode> q = new LinkedList<>();
        q.add(new MyNode(root, 0, 0));
        int curlevel = -1;
        int saved = 0;
        int maxpos = 0;
        while (!q.isEmpty()) {
            MyNode n = q.poll();
            TreeNode temp = n.node;
            if (temp.left != null) {
                q.add(new MyNode(temp.left, n.level+1, 2*n.pos));
            }
            if (temp.right != null) {
                q.add(new MyNode(temp.right, n.level+1, 2*n.pos+1));
            }
            if (curlevel != n.level) {
                curlevel = n.level;
                saved = n.pos;
            }
            maxpos = Math.max(maxpos, n.pos-saved+1);
        }
        return maxpos;
    }
}

class Solution {
    HashMap<Integer, Integer> map;
    int maxwid;
    public int widthOfBinaryTree(TreeNode root) {
        map = new HashMap<>();
        maxwid = 0;
        helper(root, 0, 0);
        return maxwid;
    }
    private void helper(TreeNode node, int level, int pos) {
        if (node == null) {
            return;
        }
        if (!map.containsKey(level)) {
            map.put(level, pos);
        }
        helper(node.left, level+1, pos*2);
        helper(node.right, level+1, pos*2+1);
        maxwid = Math.max(maxwid, pos-map.get(level)+1);
    }
}