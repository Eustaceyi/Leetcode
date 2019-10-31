class Solution {
    List<List<Integer>> ans;
    public List<List<Integer>> combinationSum3(int k, int n) {
        ans = new ArrayList<>();
        dfs(1, k, 0, n, new ArrayList<>());
        return ans;
    }
    private void dfs(int start, int left, int sum, int n, List<Integer> ls) {
        if (left == 0) {
            if (sum == n) {
                ans.add(new ArrayList<>(ls));
            }
            return;
        }
        if (10-start < left) {
            return;
        } 
        if (sum + start > n) {
            return;
        }
        for (int i=start; i<10; i++) {
            ls.add(i);
            dfs(i+1, left-1, sum+i, n, ls);
            ls.remove(ls.size()-1);
        }
    }
}