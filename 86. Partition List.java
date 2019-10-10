/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy1 = new ListNode(0);
        ListNode dummy2 = new ListNode(0);
        ListNode node1 = dummy1, node2 = dummy2, curr = head;
        while (curr != null) {
            if (curr.val < x) {
                node1.next = curr;
                node1 = node1.next;
            } else {
                node2.next = curr;
                node2 = node2.next;
            }
            curr = curr.next;
        }
        node1.next = dummy2.next;
        node2.next = null;
        return dummy1.next;
    }
}