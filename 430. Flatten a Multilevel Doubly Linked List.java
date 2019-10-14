/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;

    public Node() {}

    public Node(int _val,Node _prev,Node _next,Node _child) {
        val = _val;
        prev = _prev;
        next = _next;
        child = _child;
    }
};
*/
class Solution {
    public Node flatten(Node head) {
        if (head == null || (head.next == null && head.child == null)) {
            return head;
        }
        Node next = null, node = head, temp=null;
        while (node != null) {
            next = node.next;
            if (node.child != null) {
                temp = flatten(node.child);
                node.child = null;
                temp.prev = node;
                node.next = temp;
                while (temp.next != null) {
                    temp = temp.next;
                }
                if (next != null) {
                    temp.next = next;
                    next.prev = temp;
                }
            }
            node = next;
        }
        return head;
    }
}

class Solution {
    public Node flatten(Node head) {
        if (head == null || (head.next == null && head.child == null)) {
            return head;
        }
        Node next = null, node = head, temp=null;
        while (node != null) {
            next = node.next;
            if (node.child != null) {
                temp = node.child;
                node.next = temp;
                temp.prev = node;
                while (temp.next != null) {
                    temp = temp.next;
                }
                temp.next = next;
                if (next != null) {
                    next.prev = temp;
                }
                node.child = null;
            } else {
                node = node.next;
            }
        }
        return head;
    }
}