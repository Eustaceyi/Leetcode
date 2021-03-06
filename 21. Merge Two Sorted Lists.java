/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dh = new ListNode(0);
        ListNode node = dh;
        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                node.next = l2;
                node = node.next;
                l2 = l2.next;
            } else {
                node.next = l1;
                node = node.next;
                l1 = l1.next;
            }
        }
        if (l1 != null) {
            node.next = l1;
            return dh.next;
        } else {
            node.next = l2;
            return dh.next;
        }
    }
}