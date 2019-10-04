/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode next = head.next;
        ListNode node = head;
        head = next;
        ListNode prev = null;
        while (next != null && node != null) {
            ListNode nextnext = next.next;
            if (prev != null) {
                prev.next = next;
            }
            node.next = nextnext;
            next.next = node;
            prev = node;
            if (node.next == null || node.next.next == null) {
                break;
            }
            node = node.next;
            next = node.next;
        }
        return head;
    }
}