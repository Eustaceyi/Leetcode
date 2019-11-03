class Solution {
    public int findShortestSubArray(int[] nums) {
        HashMap<Integer, Integer> left = new HashMap<>(), right = new HashMap<>(), count = new HashMap<>();
        for (int i=0; i<nums.length; i++) {
            count.put(nums[i], count.getOrDefault(nums[i], 0)+1);
            right.put(nums[i], i);
            if (!left.containsKey(nums[i])) {
                left.put(nums[i], i);
            }
        }
        int degree = Collections.max(count.values());
        int ans = nums.length;
        for (int x : count.keySet()) {
            if (count.get(x) == degree) {
                ans = Math.min(ans, right.get(x) - left.get(x)+1);
            }
        }
        return ans;
    }
}