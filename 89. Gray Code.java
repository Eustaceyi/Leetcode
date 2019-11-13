class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> ans = new ArrayList<>();
        ans.add(0);
        for (int i=1; i<=n; i++) {
            int size = ans.size();
            for (int j=0; j<size; j++) {
                ans.add(ans.get(size-j-1) + (int)Math.pow(2, i-1));
            }
        }
        return ans;
    }
}