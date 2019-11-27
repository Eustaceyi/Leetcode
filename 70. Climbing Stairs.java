/**
 * dp solution 
 * Time O(n)
 * Space O(1)
 */
class Solution {
    public int climbStairs(int n) {
        if (n==1 || n==2) {
            return n;
        }
        int n_2 = 1;
        int n_1 = 1;
        int count = 1;
        while (count < n) {
            int temp = n_2 + n_1;
            n_2 = n_1;
            n_1 = temp;
            count++;
        }
        return n_1;
    }
}