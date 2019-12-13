class Solution {
    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix==null || matrix.length==0 || matrix[0].length==0) {
            return new int[0];
        }
        int m = matrix.length, n = matrix[0].length;
        boolean up = true;
        int[] ans = new int[m*n];
        int index = 0;
        for (int i=0; i<m+n-1; i++) {
            if (up) {
                for (int j=Math.max(0, i-m+1); j<=Math.min(i, n-1); j++) {
                    ans[index++] = matrix[i-j][j];
                }
            } else {
                for (int j=Math.min(i, n-1); j>=Math.max(0, i-m+1); j--) {
                    ans[index++] = matrix[i-j][j];
                }
            }
            up = !up;
        }
        return ans;
    }
}