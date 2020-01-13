/**
 * key point:
 * a % k = x
 * b % k = x
 * (a - b) % k = x - x = 0
 * here a - b = the sum between i and j
 * using this point, we could have a hashmap storing the mod result
 * ans its first position, and if we meet the same result again,
 * we could judge the result by index difference
 */
class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        if (nums==null || nums.length <= 1) {
            return false;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int sum = 0;
        for (int i=0; i<nums.length; i++) {
            sum += nums[i];
            if (k != 0) {
                sum = sum % k;
            }
            if (map.containsKey(sum)) {
                if (i-map.get(sum) > 1) {
                    return true;
                } 
            } else {
                map.put(sum, i);
            }
        }
        return false;
    }
}