class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int AE = Math.max(A, E);
        int BF = Math.max(B, F);
        int CG = Math.min(C, G);
        int DH = Math.min(D, H);
        int dup = 0;
        if (AE < CG && BF < DH) {
            dup = (DH-BF) * (CG-AE);
        }
        return (C-A) * (D-B) + (H-F) * (G-E) - dup;
    }
}