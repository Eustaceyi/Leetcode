/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
/**
 * Convert into undirected graph, and bfs
 * Time O(n) build graph is one pass, and bfs is another pass
 * Space O(n)
 * Or we can only map the node with its parent and do a bfs
 * this will be a little bit faster
 */
class Solution {
    HashMap<Integer, HashSet<Integer>> graph;
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        graph = new HashMap<>();
        buildGraph(root);
        HashSet seen = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();
        q.add(target.val); seen.add(target.val);
        while (K > 0) {
            int size = q.size();
            for (int i=0; i<size; i++) {
                int val = q.poll();
                HashSet<Integer> set = graph.getOrDefault(val, new HashSet<>());
                for (int item : set) {
                    if (!seen.contains(item)) {
                        q.add(item);
                    }
                    seen.add(item);
                }
            }
            K--;
        }
        return new LinkedList<>(q);
    }
    private void buildGraph(TreeNode root) {
        if (root != null) {
            HashSet set;
            if (root.left != null) {
                set = graph.getOrDefault(root.val, new HashSet<>());
                set.add(root.left.val);
                graph.put(root.val, set);
                
                set = graph.getOrDefault(root.left.val, new HashSet<>());
                set.add(root.val);
                graph.put(root.left.val, set);
            }
            if (root.right != null) {
                set = graph.getOrDefault(root.val, new HashSet<>());
                set.add(root.right.val);
                graph.put(root.val, set);
                
                set = graph.getOrDefault(root.right.val, new HashSet<>());
                set.add(root.val);
                graph.put(root.right.val, set);
            }
            buildGraph(root.left);
            buildGraph(root.right);
        }
    }
}