class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        dfs(new ArrayList<>(), 0, k, n, ans);
        return ans;
    }
    private void dfs(List<Integer> curr, int start, int k, int n, List<List<Integer>> ans) {
        if (curr.size() == k) {
            ans.add(new ArrayList<>(curr));
            return;
        }
        for (int i=start; i<n; i++) {
            curr.add(i+1);
            dfs(curr, i+1, k, n, ans);
            curr.remove(curr.size()-1);
        }
    }
}