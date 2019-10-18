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
    int[] nums;
    public TreeNode sortedArrayToBST(int[] nums) {
        this.nums = nums;
        return helper(0, nums.length-1);
    }
    private TreeNode helper(int st, int ed) {
        if (st > ed) {
            return null;
        } else if (st == ed) {
            return new TreeNode(nums[st]);
        } else {
            int mid = (ed-st)/2+st;
            TreeNode node = new TreeNode(nums[mid]);
            node.left = helper(st, mid-1);
            node.right = helper(mid+1, ed);
            return node;
        }
    }
}