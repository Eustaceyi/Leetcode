import java.util.ArrayList;
import java.util.List;

import javax.swing.tree.TreeNode;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    /**
     * backtracking
     * Points to notice:
     * 1. for java, we need to remove the point we add after the recursion
     * 2. when we add new list into the result, we need to make a deep copy (new ArrayList<>(temp))
     * @param root
     * @param sum
     * @return
     */
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if(root == null){
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        helper(root,sum, new ArrayList<>(), res);
        return res;
    }
    
    public void helper(TreeNode root, int sum, List<Integer> temp, List<List<Integer>> res){
        if(root == null){
            return;
        }
        temp.add(root.val);
        
        if(root.left == null && root.right == null && root.val == sum){
            res.add(new ArrayList<>(temp));
            temp.remove(temp.size() -1);
            return;
        }
        helper(root.left, sum - root.val, temp, res);
        helper(root.right, sum - root.val, temp, res);
        temp.remove(temp.size() -1);
    }
}