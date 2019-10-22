/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    public String serialize(TreeNode root) {
        String n = "null", comma = ",";
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> dq = new LinkedList<>();
        dq.offer(root);
        while (!dq.isEmpty()) {
            int size = dq.size();
            for (int i=0;i<size;i++) {
                TreeNode node = dq.poll();
                if (node == null) {
                    sb.append(n);
                    sb.append(comma);
                } else {
                    sb.append(Integer.toString(node.val));
                    sb.append(comma);
                    dq.offer(node.left);
                    dq.offer(node.right);
                }
            }
        }
        return sb.toString();
    }

    public TreeNode deserialize(String data) {
        String[] strs = data.split(",");
        Queue<TreeNode> dq = new LinkedList<>();
        if (strs[0].equals("null")) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(strs[0]));
        dq.offer(root);
        int pos = 1;
        while (!dq.isEmpty() && pos < strs.length) {
            TreeNode node = dq.poll();
            String left = strs[pos++];
            if (!left.equals("null")) {
                TreeNode nl = new TreeNode(Integer.parseInt(left));
                node.left = nl;
                dq.offer(nl);
            }
            String right = strs[pos++];
            if (!right.equals("null")) {
                TreeNode nr = new TreeNode(Integer.parseInt(right));
                node.right = nr;
                dq.offer(nr);
            }
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));