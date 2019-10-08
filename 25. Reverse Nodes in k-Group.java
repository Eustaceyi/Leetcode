/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode prev=dummy, curr=head, fast=head, next=null;
        ListNode con=dummy, tail=dummy;
        while (true) {
            int count = 0;
            while (fast != null && count < k) {
                fast = fast.next;
                count++;
            }
            if (count != k) {
                return dummy.next;
            }
            
            con = tail;
            tail = curr;
            while (count > 0) {
                next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
                count--;
            }
            con.next = prev;
            tail.next = curr;
        }
    }
}