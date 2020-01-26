class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int satisified = 0;
        int maxToSat = 0;
        int toSat = 0;
        for (int i=0; i<customers.length; i++) {
            if (i >= X) {
                toSat -= grumpy[i-X] * customers[i-X];
            }
            satisified += (1-grumpy[i]) * customers[i];
            toSat += grumpy[i] * customers[i];
            maxToSat = Math.max(maxToSat, toSat);
        }
        return satisified + maxToSat;
    }
}