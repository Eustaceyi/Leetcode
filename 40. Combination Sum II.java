/**
 * backtracking solution
 * Time O(2^n)
 * Space O(n)
 */
class Solution {
    List<List<Integer>> ans;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        ans = new LinkedList<>();
        if (candidates == null || candidates.length == 0) {
            return ans;
        }
        Arrays.sort(candidates);
        backtrack(candidates, target, 0, new LinkedList<>());
        return ans;
    }
    private void backtrack(int[] can, int target, int start, List<Integer> curr)  {
        if (target < 0) {
            return;
        } else if (target == 0) {
            ans.add(new LinkedList(curr));
            return;
        }
        for (int i=start; i<can.length; i++) {
            curr.add(can[i]);
            backtrack(can, target-can[i], i+1, curr);
            curr.remove(curr.size()-1);
            // this is to prevent duplicate solution
            while (i < can.length-1 && can[i] == can[i+1]) {
                i++;
            }
        }
    }
}