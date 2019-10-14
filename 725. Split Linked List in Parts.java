/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode[] splitListToParts(ListNode root, int k) {
        ListNode node = root;
        ListNode[] res = new ListNode[k];
        int len = 0;
        while (node != null) {
            len++;
            node = node.next;
        }
        if (len == 0) {
            return res;
        }
        
        int partlen = len/k, count;
        node = root;
        ListNode prev = null;
        for (int i=0; i<k; i++) {
            count = 0;
            if (node == null) {
                break;
            }
            res[i] = node;
            while (count < partlen) {
                prev = node;
                node = node.next;
                count++;
            }
            if (i < len%k) {
                prev = node;
                node = node.next;
            }
            prev.next = null;
        }
        return res;
    }
}