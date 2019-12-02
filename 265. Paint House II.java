/**
 * For each house, we find out the 1st smallest and 2nd smallest of previous houses,
 * and add to curr house, if the 1st smallest is not the same as curr color, else add 2nd smallest
 * by doing this we can do O(k) in every house instead of O(k^2) by finding every smallest of each color
 * Total time O(nk) Space O(1)
 */
class Solution {
    public int minCostII(int[][] costs) {
        if (costs==null || costs.length==0 || costs[0].length==0) {
            return 0;
        }
        int n = costs.length, k = costs[0].length;
        int min1=Integer.MAX_VALUE, min2=Integer.MAX_VALUE, id1=-1, id2=-1;
        for (int i=0; i<n; i++) {
            int[] cost = costs[i];
            min1=Integer.MAX_VALUE;
            min2=Integer.MAX_VALUE;
            id1=-1; id2=-1;
            for (int j=0; j<k; j++) {
                if (cost[j] < min1) {
                    min2 = min1;
                    min1 = cost[j];
                    id2 = id1;
                    id1 = j;
                } else if (cost[j] < min2) {
                    min2 = cost[j];
                    id2 = j;
                }
            }
            if (i < n-1) {
                for (int j=0; j<k; j++) {
                    if (j == id1) {
                        costs[i+1][j] += cost[id2];
                    } else {
                        costs[i+1][j] += cost[id1];
                    }
                }
            }
        }
        return costs[n-1][id1];
    }
}