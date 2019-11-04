/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {}

    public Node(int _val,List<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
};
*/
/**
 * DFS iteration method
 * Time O(N * E)
 * Space O(N)
 */
class Solution {
    public Node cloneGraph(Node node) {
        HashMap<Node, Node> map = new HashMap<>();
        Deque<Node> stack = new ArrayDeque<>();
        HashSet<Node> seen = new HashSet<>();
        Node cnode = new Node(node.val, new ArrayList<>());
        map.put(node, cnode);
        stack.push(node);
        seen.add(node);
        Node head = node;
        while (!stack.isEmpty()) {
            node = stack.pop();
            for (Node topush : node.neighbors) {
                if (!seen.contains(topush)) {
                    seen.add(topush);
                    stack.push(topush);
                }
                if (map.containsKey(topush)) {
                    map.get(node).neighbors.add(map.get(topush));
                } else {
                    cnode = new Node(topush.val, new ArrayList<>());
                    map.put(topush, cnode);
                    map.get(node).neighbors.add(cnode);
                }  
            }
        }
        return map.get(head);
    }
}
/**
 * BFS iteration method
 * Same as DFS iteration
 */
class Solution {
    public Node cloneGraph(Node node) {
        HashMap<Node, Node> map = new HashMap<>();
        Deque<Node> queue = new ArrayDeque<>();
        HashSet<Node> seen = new HashSet<>();
        Node cnode = new Node(node.val, new ArrayList<>());
        map.put(node, cnode);
        queue.offerLast(node);
        seen.add(node);
        Node head = node;
        while (!queue.isEmpty()) {
            node = queue.pollFirst();
            for (Node topush : node.neighbors) {
                if (!seen.contains(topush)) {
                    seen.add(topush);
                    queue.offerLast(topush);
                }
                if (map.containsKey(topush)) {
                    map.get(node).neighbors.add(map.get(topush));
                } else {
                    cnode = new Node(topush.val, new ArrayList<>());
                    map.put(topush, cnode);
                    map.get(node).neighbors.add(cnode);
                }  
            }
        }
        return map.get(head);
    }
}
/**
 * DFS recursion
 * same as above
 */
class Solution {
    public Node cloneGraph(Node node) {
        HashMap<Node, Node> map = new HashMap<>();
        HashSet<Node> seen = new HashSet<>();
        dfs(node, map, seen);
        return map.get(node);
    }
    private void dfs(Node node, HashMap<Node, Node> map, HashSet<Node> seen) {
        seen.add(node);
        if (!map.containsKey(node)) {
            map.put(node, new Node(node.val, new ArrayList<>()));
        }
        for (Node next : node.neighbors) {
            if (!map.containsKey(next)) {
                map.put(next, new Node(next.val, new ArrayList<>()));
            }
            map.get(node).neighbors.add(map.get(next));
            if (!seen.contains(next)) {
                dfs(next, map, seen);
            }
        }
    }
}