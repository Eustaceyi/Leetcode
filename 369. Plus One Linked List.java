/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode plusOne(ListNode head) {
        int carry = addOne(head);
        if (carry != 0) {
            ListNode newhead = new ListNode(1);
            newhead.next = head;
            head = newhead;
        }
        return head;
    }
    
    private int addOne(ListNode head) {
        if (head == null) {
            return 1;
        }
        int carry = (head.val + addOne(head.next));
        head.val = carry % 10;
        carry = carry / 10;
        return carry;
    }
}