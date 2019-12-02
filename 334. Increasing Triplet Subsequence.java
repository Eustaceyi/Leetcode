class Solution {
    public boolean increasingTriplet(int[] nums) {
        int m1 = Integer.MAX_VALUE, m2 = Integer.MAX_VALUE;
        for (int i : nums) {
            if (i <= m1) { // update the smaller one if we meet a smaller one than both
                m1 = i;
            } else if (i <= m2) { // update this if we have already meet a smaller in m1
                m2 = i;
            } else {
                return true; // when it reaches here, it means that we have m1 < m2 < i
            }
        }
        return false;
    }
}