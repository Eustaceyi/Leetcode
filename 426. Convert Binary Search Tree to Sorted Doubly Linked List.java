/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
*/
class Solution {
    Node first;
    Node last;
    
    public Node treeToDoublyList(Node root) {
        if (root==null) {
            return null;
        }
        helper(root);
        
        last.right = first;
        first.left = last;
        return first;
    }
    
    private void helper(Node node) {
        if (node != null) {
            helper(node.left);
            if (last != null) {
                last.right = node;
                node.left = last;
            } else {
                first = node;
            }
            last = node;
            helper(node.right);
        }
    }
}

class Solution {
    public Node treeToDoublyList(Node root) {
        Deque<Node> stack = new LinkedList<>();
        Deque<Node> dq = new LinkedList<>();
        if (root==null) {
            return root;
        }
        if (root.left == null && root.right == null) {
            root.left = root;
            root.right = root;
            return root;
        }
        Node curr = root, node = null, prev = null, head=null;
        while (curr != null || !stack.isEmpty()) {
            while(curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            if (head==null) {
                head = curr;
            }
            prev = node;
            node = curr;
            node.left = prev;
            if (prev != null) {
                prev.right = node;
            }
            curr = curr.right;
        }
        node.right = head;
        head.left = node;
        return head;
    }
}