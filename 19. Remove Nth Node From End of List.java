/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head;
        ListNode slow = head;
        ListNode slowPrev = head;
        for (int i=0; i<n; i++) {
            fast = fast.next;
        }
        if (fast == null) {
            head = head.next;
            return head;
        }
        while (fast != null) {
            fast = fast.next;
            slowPrev = slow;
            slow = slow.next;
        }
        slowPrev.next = slow.next;
        return head;
    }
}