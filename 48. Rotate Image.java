class Solution {
    /**
     * rotate the upper left rectangle ((n+1)/2, n/2) of the matrix with size n
     * use temp to save value;
     * @param matrix
     */
    public void rotate(int[][] matrix) {
        if (matrix==null || matrix.length==0) {
            return;
        }
        int n = matrix.length;
        for (int i = 0; i < (n + 1) / 2; i ++) {
            for (int j = 0; j < n / 2; j++) {
                int temp = matrix[n - 1 - j][i];
                matrix[n - 1 - j][i] = matrix[n - 1 - i][n - j - 1];
                matrix[n - 1 - i][n - j - 1] = matrix[j][n - 1 -i];
                matrix[j][n - 1 - i] = matrix[i][j];
                matrix[i][j] = temp;
            }
        }
    }
}