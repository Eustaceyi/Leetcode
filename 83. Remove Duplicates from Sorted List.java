/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode prev=null, node=head;
        while (node != null) {
            prev = node;
            node = node.next;
            while (node != null && node.val == prev.val){
                node = node.next;
            }
            prev.next = node;
        }
        return head;
    }
}