/**
 * dp solution, in each step:
 * (1) if we want to use the same color as prev one, we can only use the number of prev diff, curr_same = prev_diff
 * (2) if we want to use the diff color as prev one, we can use diff and the same and choose the different color as prev, 
 *     curr_diff = prev_same*(k-1) + prev_diff*(k-1)
 */
class Solution {
    public int numWays(int n, int k) {
        if (n * k==0) {
            return 0;
        }
        int same = 0;
        int diff = k;
        for (int i=1; i<n; i++) {
            int sametemp = diff;
            int difftemp = same * (k-1) + diff * (k-1);
            same = sametemp;
            diff = difftemp;
        }
        return same + diff;
    }
}