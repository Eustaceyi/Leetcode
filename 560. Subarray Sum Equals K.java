class Solution {
    public int subarraySum(int[] nums, int k) {
        int count=0, sum=0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        for (int i : nums) {
            sum += i;
            count += map.getOrDefault(sum-k, 0);
            map.put(sum, map.getOrDefault(sum, 0)+1);
        }
        return count;
    }
}