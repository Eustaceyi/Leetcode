/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public int numComponents(ListNode head, int[] G) {
        Set<Integer> s = new HashSet<Integer>();
        for (int i : G) {
            s.add(i);
        }
        int ans = 0;
        while (head != null) {
            if (s.contains(head.val) && (head.next == null || !s.contains(head.next.val))) {ans++;}
            head = head.next;
        }
        return ans;
    }
}