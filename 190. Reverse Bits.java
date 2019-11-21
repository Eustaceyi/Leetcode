public class Solution {
    //you need treat n as an unsigned value
    /**
     * This is the looping way to do this
     * @param n
     * @return
     */
    public int reverseBits(int n) {
        int ans = 0;
        int count = 0;
        while (count < 32) {
            int temp = n & 1;
            ans = (ans << 1) + temp;
            n = n >>> 1;
            count++;
        }
        return ans;
    }
    /**
     * This is the bits way to do this
     * ABCDEFGH -> EFGHABCD
     * EFGHABCD -> GHEFCDAB
     * GHEFCDAB -> HGEFDCBA
     * @param n
     * @return
     */
    public int reverseBits(int n) {
        int ret=n;
        ret = ret >>> 16 | ret<<16;
        ret = (ret & 0xff00ff00) >>> 8 | (ret & 0x00ff00ff) << 8;
        ret = (ret & 0xf0f0f0f0) >>> 4 | (ret & 0x0f0f0f0f) << 4;
        ret = (ret & 0xcccccccc) >>> 2 | (ret & 0x33333333) << 2;
        ret = (ret & 0xaaaaaaaa) >>> 1 | (ret & 0x55555555) << 1;
        return ret;
    }
}