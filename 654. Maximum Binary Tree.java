/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
/**
 * Recursion method Time O(n^2) Space O(n)
 */
class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums == null || nums.length==0) {
            return null;
        }
        if (nums.length==1) {
            return new TreeNode(nums[0]);
        }
        int maxidx = 0, maxv = Integer.MIN_VALUE;
        for (int i=0;i<nums.length;i++) {
            if (nums[i] > maxv) {
                maxv = nums[i];
                maxidx = i;
            }
        }
        TreeNode root = new TreeNode(maxv);
        root.left = constructMaximumBinaryTree(Arrays.copyOfRange(nums, 0, maxidx));
        root.right = constructMaximumBinaryTree(Arrays.copyOfRange(nums, maxidx+1, nums.length));
        return root;
    }
}

/**
 * One pass solution, uses a decreasing stack to keep track of nodes
 */
class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        Deque<TreeNode> stack = new LinkedList<>();
        for(int i = 0; i < nums.length; i++) {
            TreeNode curr = new TreeNode(nums[i]);
            while(!stack.isEmpty() && stack.peekLast().val < nums[i]) {
                curr.left = stack.pollLast();
            }
            if(!stack.isEmpty()) {
                stack.peekLast().right = curr;
            }
            stack.addLast(curr);
        }
        
        return stack.isEmpty() ? null : stack.peekFirst();
    }
}