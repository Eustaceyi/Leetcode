/**
 * one pass,
 * this has more strict suituations
 * Time O(n)
 * Space O(1)
 */
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int total=0, startpos=0, curr=0;
        for (int i=0; i<n; i++) {
            curr += gas[i] - cost[i];
            total += gas[i] - cost[i];
            if (curr < 0) {
                curr = 0;
                startpos = i+1;
            }
        }
        if (total >= 0) {
            return startpos;
        } else {
            return -1;
        }
    }
}
/**
 * O(n) solution
 * the second pass in the for loop is for checking that we actually can go the loop
 */
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int[] left = new int[n];
        int total = 0;
        for (int i=0; i<n; i++) {
            left[i] = gas[i] - cost[i];
            total += left[i];
        }
        if (total < 0) {
            return -1;
        }
        int startpos=0, curr=0;
        for (int i=0; i<n*2; i++) {
            if (i-startpos == n) {
                break;
            }
            curr += left[i%n];
            if (curr < 0) {
                curr = 0;
                startpos = i+1;
            }
        }
        if (startpos < n) {
            return startpos;
        } else {
            return -1;
        }
    }
}