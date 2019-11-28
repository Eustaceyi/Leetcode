/**
 * dp solution, Time O(n) Space O(1) or O(n) if we are not modifying the array
 */
class Solution {
    public int minCost(int[][] costs) {
        if (costs==null || costs.length==0) {
            return 0;
        }
        for (int i=1; i<costs.length; i++) {
            costs[i][0] += Math.min(costs[i-1][1], costs[i-1][2]);
            costs[i][1] += Math.min(costs[i-1][0], costs[i-1][2]);
            costs[i][2] += Math.min(costs[i-1][1], costs[i-1][0]);
        }
        return Math.min(costs[costs.length-1][0], Math.min(costs[costs.length-1][1], costs[costs.length-1][2]));
    }

    public int minCost(int[][] costs) {
        int red = 0, green = 0, blue = 0;
        int m = costs.length;
        for (int i = 0; i < m; i++) {
            int tempR = red;
            red = Math.min(green, blue) + costs[i][0];
            int tempG = green;
            green = Math.min(tempR, blue) + costs[i][1];
            blue = Math.min(tempR, tempG) + costs[i][2];
        }
        return Math.min(Math.min(red, green), blue);      
    }
}