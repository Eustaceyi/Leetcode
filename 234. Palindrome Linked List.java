/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode node=head, prev=null, next=null, fast=head, slow=head;
        while (fast!=null && fast.next!=null) {
            fast = fast.next.next;
            slow = slow.next;
            next = node.next;
            node.next = prev;
            prev = node;
            node = next;
        }
        if (fast != null) {
            slow = slow.next;
        }
        while (slow != null) {
            if (slow.val != prev.val) {
                return false;
            }
            prev = prev.next;
            slow = slow.next;
        }
        return true;
    }
}