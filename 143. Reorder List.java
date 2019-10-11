/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        ListNode fast=head, slow=head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode prev=null, curr=slow, next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        ListNode n1=head, n2=prev;
        while (n1 != null) {
            next = n1.next;
            n1.next = n2;
            n1 = next;
            if (n2 == null) {
                break;
            }
            next = n2.next;
            n2.next = n1;
            n2 = next;
        }
    }
}