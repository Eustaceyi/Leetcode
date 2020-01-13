class Solution {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        int maxx1 = Math.max(rec1[0], rec2[0]);
        int maxy1 = Math.max(rec1[1], rec2[1]);
        int minx2 = Math.min(rec1[2], rec2[2]);
        int miny2 = Math.min(rec1[3], rec2[3]);
        if (maxx1 < minx2 && maxy1 < miny2) {
            return true;
        }
        return false;
    }
}