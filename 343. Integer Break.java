class Solution {
    private int[] res;
    
    public Solution() {
        res = new int[59];
        res[1] = 1;
        res[2] = 1;
        res[3] = 2;
        res[4] = 4;
        res[5] = 6;
        res[6] = 9;
        res[7] = 12;
        for (int i=8; i<59; i++) {
            res[i] = 3 * res[i-3];
        }
    }
    
    public int integerBreak(int n) {
        return res[n];
    }
}