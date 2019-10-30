class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int lo=0, hi=numbers.length-1;
        while (lo<hi) {
            int temp = numbers[lo] + numbers[hi];
            if (temp == target) {
                return new int[] {lo+1, hi+1};
            }
            if (temp > target) {
                hi--;
            } else {
                lo++;
            }
        }
        return new int[] {0,0};
    }
}