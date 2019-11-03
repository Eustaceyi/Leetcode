class Solution {
    public int minDominoRotations(int[] A, int[] B) {
        int len = A.length;
        int res = check(A[0], A, B, len);
        if (res != -1 || A[0] == B[0]) {
            return res;
        }
        return check(B[0], A, B, len);
    }
    private int check(int x, int[] A, int[] B, int len) {
        int ra=0; int rb=0;
        for (int i=0; i<len; i++){
            if (A[i] != x && B[i] != x) {
                return -1;
            } else if (A[i] != x) {
                ra++;
            } else if (B[i] != x) {
                rb++;
            }
        }
        return Math.min(ra, rb);
    }
}