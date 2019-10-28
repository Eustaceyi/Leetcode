/**
 * Time O(2^n)
 * Space O(n)
 */
class Solution {
    List<List<Integer>> ans;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        ans = new ArrayList<>();
        ans.add(new ArrayList<>());
        if (nums==null || nums.length==0) {
            return ans;
        }
        Arrays.sort(nums);
        for (int i=0; i<nums.length; i++) {
            if (i>0 && nums[i] == nums[i-1]) {
                continue;
            }
            dfs(nums, new ArrayList<>(), i);
        }
        return ans;
    }
    private void dfs(int[] nums, List<Integer> l, int pos) {
        l.add(nums[pos]);
        ans.add(new ArrayList(l));
        for (int i=pos+1; i<nums.length; i++) {
            if (i>pos+1 && nums[i] == nums[i-1]) {
                continue;
            }
            dfs(nums, l, i);
        }
        l.remove(l.size()-1);
    }
}