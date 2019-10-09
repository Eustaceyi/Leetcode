/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }
        ListNode node = head;
        int length = 1;
        while (node.next != null) {
            node = node.next;
            length++;
        }
        k = k % length;
        ListNode prev = null;
        ListNode newhead = head;
        for (int i = 0; i < length-k;i++) {
            prev = newhead;
            newhead = newhead.next;
        }
        if (newhead == null) {
            return head;
        } else {
            prev.next = null;
            node.next = head;
            return newhead;
        }
    }
}