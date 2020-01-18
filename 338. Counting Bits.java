class Solution {
    public int[] countBits(int num) {
        if (num < 0) {return new int[0];}
        int[] ans = new int[num+1];
        int pow = 1;
        for (int i=1; i<=num; i++) {
            if (i == pow * 2) {
                pow = i;
            }
            ans[i] = ans[i-pow]+1;
        }
        return ans;
    }
}

/**
 * P(x) = P(x / 2) + (x mod 2)
 * this is thinking that the bit 1 in this number is either the same as this
 * or adding one by looking at the last bit
 */
public class Solution {
    public int[] countBits(int num) {
        int[] ans = new int[num + 1];
        for (int i = 1; i <= num; ++i)
          ans[i] = ans[i >> 1] + (i & 1); // x / 2 is x >> 1 and x % 2 is x & 1
        return ans;
    }
}

public class Solution {
    public int[] countBits(int num) {
        int[] ans = new int[num + 1];
        for (int i = 1; i <= num; ++i)
          ans[i] = ans[i & (i - 1)] + 1;
        return ans;
    }
}