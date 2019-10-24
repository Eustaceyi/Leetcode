/**
 * backracking answer 
 * Time O(arraylength^target)
 * Space O(target)
 */
class Solution {
    List<List<Integer>> ans;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        ans = new LinkedList<>();
        if (candidates==null || candidates.length==0) {
            return ans;
        }
        Arrays.sort(candidates);
        backtrack(candidates, target, new LinkedList<>());
        return ans;
    }
    private void backtrack(int[] cans, int target, List<Integer> curr) {
        if (target==0) {
            ans.add(new LinkedList<>(curr));
            return;
        }
        if (target < 0) {
            return;
        }
        for (int i : cans) {
            if (curr.size() > 0 && i < curr.get(curr.size()-1)) {
                continue;
            }
            curr.add(i);
            backtrack(cans, target-i, curr);
            curr.remove(curr.size()-1);
        }
    }
}