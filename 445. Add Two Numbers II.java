/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers_reverse(ListNode l1, ListNode l2) {
        // 1. reverse two lls and add them;
        ListNode l1v = reverse(l1);
        ListNode l2v = reverse(l2);
        return reverse(addTwo(l1v, l2v));
    }

    public ListNode addTwoNumbers_stack(ListNode l1, ListNode l2) {
        // 2. using stack to add two number;
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        Stack<Integer> l1s = new Stack<Integer>();
        Stack<Integer> l2s = new Stack<Integer>();
        while (l1 != null) {
            l1s.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            l2s.push(l2.val);
            l2 = l2.next;
        }
        ListNode dummy = new ListNode(0);
        ListNode node = dummy;
        int temp=0, carry=0;
        while (!l1s.empty() && !l2s.empty()) {
            temp = l1s.pop() + l2s.pop() + carry;
            carry = temp / 10;
            node.next = new ListNode(temp % 10);
            node = node.next;
        }
        while (!l1s.empty()) {
            temp = l1s.pop() + carry;
            carry = temp / 10;
            node.next = new ListNode(temp % 10);
            node = node.next;
        }
        while (!l2s.empty()) {
            temp = l2s.pop() + carry;
            carry = temp / 10;
            node.next = new ListNode(temp % 10);
            node = node.next;
        }
        if (carry != 0) {
            node.next = new ListNode(carry);
            node = node.next;
        }
        return reverse(dummy.next);
    }

    public ListNode addTwoNumbers_recursion(ListNode l1, ListNode l2) {
        // 3. count length and add them with recursion
        ListNode node = l1;
        int l1length = 0;
        while (node != null) {
            l1length++;
            node = node.next;
        }
        node = l2;
        int l2length = 0;
        while (node != null) {
            l2length++;
            node = node.next;
        }
        if (l1length > l2length) {
            int carry = addTwoNode(l1, l2, l1length-l2length);
            if (carry != 0) {
                ListNode newhead = new ListNode(carry);
                newhead.next = l1;
                return newhead;
            } else {
                return l1;
            }
        } else {
            int carry = addTwoNode(l2, l1, l2length-l1length);
            if (carry != 0) {
                ListNode newhead = new ListNode(carry);
                newhead.next = l2;
                return newhead;
            } else {
                return l2;
            }
        }
    }
    
    private int addTwoNode(ListNode l1, ListNode l2, int diff) {
        if (l1 == null) {
            return 0;
        }
        int temp = 0, carry = 0;
        if (diff > 0) {
            temp = l1.val + addTwoNode(l1.next, l2, diff-1);
            carry = temp / 10;
            l1.val = temp % 10;
        } else {
            temp = l1.val + l2.val + addTwoNode(l1.next, l2.next, 0);
            carry = temp / 10;
            l1.val = temp % 10;
        }
        return carry;
    }
    
    private ListNode addTwo(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode node = dummy;
        int carry = 0, temp=0;
        while (l1 != null && l2 != null) {
            temp = l1.val + l2.val + carry;
            carry = temp / 10;
            node.next = new ListNode(temp%10);
            node = node.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            temp = l1.val + carry;
            carry = temp / 10;
            node.next = new ListNode(temp%10);
            node = node.next;
            l1 = l1.next;
        }
        while (l2 != null) {
            temp = l2.val + carry;
            carry = temp / 10;
            node.next = new ListNode(temp%10);
            node = node.next;
            l2 = l2.next;
        }
        if (carry != 0) {
            node.next = new ListNode(carry);
            node = node.next;
        }
        return dummy.next;
    }
    
    private ListNode reverse(ListNode l) {
        if (l == null || l.next == null) {
            return l;
        }
        ListNode curr=l, prev=null, next=null;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}