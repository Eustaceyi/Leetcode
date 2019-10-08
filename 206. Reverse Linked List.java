/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode prev = null;
        ListNode node = head;
        ListNode next = head.next;
        while (true) {
            node.next = prev;
            prev = node;
            node = next;
            if (node == null) {
                break;
            }
            next = node.next;
        }
        return prev;
    }
}