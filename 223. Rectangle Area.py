class Solution:
    def computeArea(self, A: int, B: int, C: int, D: int, E: int, F: int, G: int, H: int) -> int:
        overlap = max(0, min(C,G)-max(A,E)) * max(0, min(D,H)-max(B,F))
        return (D-B)*(C-A) + (H-F)*(G-E) - overlap