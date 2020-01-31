/**
 * we use binary search on answer,
 * we check if the curr value is feasible or not
 * we want to find the largest feasible average
 */
class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double min = Double.MAX_VALUE, max = Double.MIN_VALUE;
        for (int i : nums) {
            min = Math.min(min, i);
            max = Math.max(max, i);
        }
        double prev_mid = max, error = Double.MAX_VALUE;
        while (error > 0.000005) {
            double mid = min + (max - min) * 0.5;
            if (process(nums, k, mid)) {
                min = mid;
            } else {
                max = mid;
            }
            error = Math.abs(mid - prev_mid);
            prev_mid = mid;
        }
        return min;
    }
    
    private boolean process(int[] nums, int k, double mid) {
        double sum = 0.0;
        for (int i=0; i<k; i++) {
            sum += nums[i] - mid;
        }
        if (sum >= 0) {
            return true;
        }
        double prev_sum = 0.0;
        double min_sum = 0.0;
        for (int i=k; i<nums.length; i++) {
            sum += nums[i] - mid;
            prev_sum += nums[i-k] - mid;
            min_sum = Math.min(prev_sum, min_sum);
            if (sum - min_sum >= 0) {
                return true;
            }
        }
        return false;
    }
}