class Solution {
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        if (A==null || A.length==0 || B==null || B.length==0) {
            return new int[0][2];
        }
        int pa=0, pb=0;
        int[] a, b;
        List<int[]> ls = new ArrayList<>();
        while (pa < A.length && pb < B.length) {
            a = A[pa];
            b = B[pb];
            if (a[1] < b[0]) {
                pa++;
            } else if (a[0] > b[1]) {
                pb++;
            } else {
                int[] in = new int[2];
                in[0] = Math.max(a[0], b[0]);
                in[1] = Math.min(a[1], b[1]);
                ls.add(in);
                if (a[1] < b[1]) {
                    pa++;
                } else {
                    pb++;
                }
            }
        }
        int[][] ans = new int[ls.size()][2];
        for (int i=0; i<ans.length; i++) {
            ans[i] = ls.get(i);
        }
        return ans;
    }
}