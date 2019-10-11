/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode insertionSortList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode node = head;
        List<Integer> l = new ArrayList<>();
        while (node != null) {
            l.add(node.val);
            node = node.next;
        }
        for (int i=1;i<l.size();i++) {
            int temp = l.get(i);
            int j = i-1;
            while (j >= 0 && l.get(j) > temp) {
                l.set(j+1, l.get(j));
                j--;
            }
            l.set(j+1, temp);
        }
        ListNode dm = new ListNode(0);
        ListNode curr = dm;
        for (int i=0;i<l.size();i++) {
            curr.next = new ListNode(l.get(i));
            curr = curr.next;
        }
        return dm.next;
    }
}

public ListNode insertionSortList(ListNode head) {
    if( head == null ){
        return head;
    }
    
    ListNode helper = new ListNode(0); //new starter of the sorted list
    ListNode cur = head; //the node will be inserted
    ListNode pre = helper; //insert node between pre and pre.next
    ListNode next = null; //the next node will be inserted
    //not the end of input list
    while( cur != null ){
        next = cur.next;
        //find the right place to insert
        while( pre.next != null && pre.next.val < cur.val ){
            pre = pre.next;
        }
        //insert between pre and pre.next
        cur.next = pre.next;
        pre.next = cur;
        pre = helper;
        cur = next;
    }
    
    return helper.next;
}