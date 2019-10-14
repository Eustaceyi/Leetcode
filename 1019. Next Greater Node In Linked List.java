/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public int[] nextLargerNodes(ListNode head) {
        // push index into stack and value in list
        // update where we meet the val is larger than in stack
        Stack<Integer> st = new Stack<Integer>();
        List<Integer> ls = new ArrayList<Integer>();
        int index = 0;
        while (head != null) {
            ls.add(head.val);
            while (!st.empty() && ls.get(st.peek()) < head.val) {
                ls.set(st.pop(), head.val);
            }
            st.push(index);
            head = head.next;
            index++;
        }
        while (!st.empty()) {
            ls.set(st.pop(), 0);
        }
        int[] res = new int[ls.size()];
        for (int i=0; i<ls.size(); i++) {
            res[i] = ls.get(i);
        }
        return res;
    }
}