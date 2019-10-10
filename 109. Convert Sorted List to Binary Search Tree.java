/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    private List<Integer> array;
    
    public Solution() {
        this.array = new ArrayList<Integer>();
    }
    
    public TreeNode sortedListToBST(ListNode head) {
        while (head != null) {
            this.array.add(head.val);
            head = head.next;
        }
        TreeNode root = ListToBST(0, array.size()-1);
        return root;
    }
    
    private TreeNode ListToBST(int left, int right) {
        if (left > right) {
            return null;
        } else if (left == right) {
            return new TreeNode(this.array.get(left));
        } else {
            int mid = (right-left) / 2 + left;
            TreeNode node = new TreeNode(this.array.get(mid));
            node.left = ListToBST(left, mid-1);
            node.right = ListToBST(mid+1, right);
            return node;
        }
    }
}