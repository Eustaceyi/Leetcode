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
 * similiar to given an array find out all subarray that has that sum
 * use hashmap and record currsum and findout all currsum-sum is already in hashmap
 */
class Solution {
    int ans;
    HashMap<Integer, Integer> map;
    int sum;
    public int pathSum(TreeNode root, int sum) {
        ans=0; this.sum = sum;
        map = new HashMap<>();
        map.put(0,1);
        helper(root, 0);
        return ans;
    }
    private void helper(TreeNode root, int currsum) {
        if (root == null) {
            return;
        }
        currsum += root.val;
        ans += map.getOrDefault(currsum-sum, 0);
        map.put(currsum, map.getOrDefault(currsum, 0)+1);
        helper(root.left, currsum);
        helper(root.right, currsum);
        map.put(currsum, map.getOrDefault(currsum, 0)-1);
    }
}