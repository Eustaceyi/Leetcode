class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix==null || matrix.length==0) {
            return false;
        }
        int m=matrix.length, n=matrix[0].length;
        int hi=m*n-1, lo=0;
        while (hi>=lo) {
            int mid = (hi-lo)/2+lo;
            if (matrix[mid/n][mid%n]==target) {
                return true;
            } else if (matrix[mid/n][mid%n] > target) {
                hi = mid-1;
            } else {
                lo = mid+1;
            }
        }
        return false;
    }
}