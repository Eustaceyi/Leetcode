/**
 * Use boolean array for seen, and then sort the array,
 * and we manually set the order of duplicated number as 
 * if the same one havn't been used, we have to use the first
 * and then use the second one.
 * Time O(n * n!)
 * Space O(n)
 */
class Solution {
    int[] nums;
    List<List<Integer>> ans;
    public List<List<Integer>> permuteUnique(int[] nums) {
        ans = new ArrayList<>();
        this.nums = nums;
        boolean[] seen = new boolean[nums.length];
        Arrays.sort(this.nums);
        helper(new ArrayList<>(), seen);
        return ans;
    }
    private void helper(List<Integer> curr, boolean[] seen) {
        if (curr.size() == nums.length) {
            ans.add(new ArrayList<>(curr));
            return;
        }
        for (int i=0; i<nums.length; i++) {
            if (seen[i]) {
                continue;
            }
            if (i>0 && nums[i] == nums[i-1] && !seen[i-1]) {
                continue;
            }
            curr.add(nums[i]);
            seen[i] = true;
            helper(curr, seen);
            curr.remove(curr.size()-1);
            seen[i] = false;
        }
    }
}