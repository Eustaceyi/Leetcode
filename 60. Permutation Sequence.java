class Solution {
    public String getPermutation(int n, int k) {
        StringBuilder sb = new StringBuilder();
        List<Integer> ls = new LinkedList<>();
        for (int i=1; i<=n; i++) {
            ls.add(i);
        }
        k-=1;
        for (int i=n-1; i>=0; i--) {
            int fact = fac(i);
            int pos = k / fact;
            sb.append(ls.remove(pos));
            k = k % fact;
        }
        return sb.toString();
    }
    private int fac(int k) {
        int res = 1;
        for (int i=1; i<=k; i++) {
            res *= i;
        }
        return res;
    }
}