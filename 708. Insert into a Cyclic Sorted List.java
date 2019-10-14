/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;

    public Node() {}

    public Node(int _val,Node _next) {
        val = _val;
        next = _next;
    }
};
*/
class Solution {
    public Node insert(Node head, int insertVal) {
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        if (head == null) {
            head = new Node(insertVal);
            head.next = head;
            return head;
        } else if (head.next == head) {
            Node node = new Node(insertVal);
            head.next = node;
            node.next = head;
            return head;
        } else {
            Node curr = head, next = head.next;
            while (true) {
                if (curr.val <= insertVal && next.val >= insertVal) {
                    Node toIns = new Node(insertVal);
                    curr.next = toIns;
                    toIns.next = next;
                    return head;
                }
                if (curr.val > next.val && (insertVal >= curr.val || insertVal <= next.val)) {
                    Node toIns = new Node(insertVal);
                    curr.next = toIns;
                    toIns.next = next;
                    return head;
                }
                min = Math.min(min, curr.val);
                max = Math.max(max, curr.val);
                curr = next;
                next = next.next;
                if (curr == head) {
                    if (max == min) {
                        Node toIns = new Node(insertVal);
                        curr.next = toIns;
                        toIns.next = next;
                    }
                    break;
                }
            }
        }
        return head;
    }
}