/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyhead = new ListNode(0);
        ListNode node = dummyhead;
        int carry = 0;
        int result = 0;
        while (l1 != null && l2 != null) {
            result = (l1.val + l2.val + carry) % 10;
            carry = (l1.val + l2.val + carry) / 10;
            node.next = new ListNode(result);
            l1 = l1.next;
            l2 = l2.next;
            node = node.next;
        }
        while (l1 != null) {
            result = (l1.val+carry) % 10;
            carry = (l1.val+carry) / 10;
            node.next = new ListNode(result);
            l1 = l1.next;
            node = node.next;
        } 
        while (l2 != null) {
            result = (l2.val+carry) % 10;
            carry = (l2.val+carry) / 10;
            node.next = new ListNode(result);
            l2 = l2.next;
            node = node.next;
        } 
        if (carry != 0) {
            node.next = new ListNode(1);
            carry = 0;
        }
        return dummyhead.next;
    }
}