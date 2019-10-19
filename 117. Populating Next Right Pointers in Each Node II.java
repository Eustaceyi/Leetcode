/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val,Node _left,Node _right,Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/
class Solution {
    public Node connect(Node root) {
        Node dummy, curr, head;
        dummy = new Node(0, null, null, null);
        curr=dummy; head=root;
        while (head!=null) {
            if (head.left!=null) {
                curr.next = head.left;
                curr = curr.next;
            }
            if (head.right!=null) {
                curr.next = head.right;
                curr = curr.next;
            }
            head = head.next;
            if (head == null) {
                head = dummy.next;
                curr = dummy;
                dummy.next = null;
            }
        }
        return root;
    }
}