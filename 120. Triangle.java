class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle==null || triangle.size()==0) {
            return 0;
        }
        int n = triangle.size();
        int[] res = new int[n];
        res[0] = triangle.get(0).get(0);
        for (int i=1; i<n; i++) {
            int[] temp = new int[n];
            List<Integer> level = triangle.get(i);
            for (int j=0; j<=i; j++) {
                if (j==0) {
                    temp[j] = res[j] + level.get(j);
                } else if (j==i) {
                    temp[j] = res[j-1] + level.get(j);
                } else {
                    temp[j] = Math.min(res[j-1], res[j]) + level.get(j);
                }
            }
            res = temp;
        }
        int minPath = Integer.MAX_VALUE;
        for (int i : res) {
            if (i < minPath) {
                minPath = i;
            }
        }
        return minPath;
    }
}