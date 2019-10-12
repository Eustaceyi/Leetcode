/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode fast=head,slow=head,prev=null;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;
        ListNode h1 = sortList(head);
        ListNode h2 = sortList(slow);
        if (h1 == null) {
            return h2;
        } else if (h2 == null) {
            return h1;
        }
        ListNode newhead;
        if (h1.val < h2.val) {
            newhead = h1;
            h1 = h1.next;
        } else {
            newhead = h2;
            h2 = h2.next;
        }
        ListNode node = newhead;
        while (h1 != null && h2 != null) {
            if (h1.val < h2.val) {
                node.next = h1;
                h1 = h1.next;
            } else {
                node.next = h2;
                h2 = h2.next;
            }
            node = node.next;
        }
        if (h1 == null) {
            node.next = h2;
        } else if (h2 == null) {
            node.next = h1;
        }
        return newhead;
    }
}