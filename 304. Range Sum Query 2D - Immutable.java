/**
 * https://leetcode.com/articles/range-sum-query-2d-immutable/
 */
class NumMatrix {
    private int[][] sums;
    
    public NumMatrix(int[][] matrix) {
        if (matrix==null || matrix.length==0) {
            sums = new int[1][1];
            return;
        }
        sums = new int[matrix.length+1][matrix[0].length+1];
        for (int i=0; i<matrix.length; i++) {
            for (int j=0; j<matrix[0].length; j++) {
                sums[i+1][j+1] = sums[i+1][j]+sums[i][j+1]+matrix[i][j]-sums[i][j];
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        return sums[row1][col1] - sums[row2+1][col1] - sums[row1][col2+1] + sums[row2+1][col2+1];
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */