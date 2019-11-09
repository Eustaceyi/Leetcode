class Solution {
    private List<List<Integer>> ans;
    int[] nums;
    public List<List<Integer>> permute(int[] nums) {
        ans = new ArrayList<>();
        this.nums = nums;
        generate(new ArrayList<>(), new HashSet<>());
        return ans;
    }
    private void generate(List<Integer> curr, Set<Integer> seen) {
        if (curr.size() == nums.length) {
            ans.add(new ArrayList<>(curr));
            return;
        }
        for (int i=0; i<nums.length; i++) {
            if (seen.contains(nums[i])) {
                continue;
            }
            curr.add(nums[i]);
            seen.add(nums[i]);
            generate(curr,seen);
            curr.remove(curr.size()-1);
            seen.remove(nums[i]);
        }
    }
}