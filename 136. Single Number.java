class Solution {
    public int singleNumber(int[] nums) {
        HashSet<Integer> seen = new HashSet<>();
        for (int i : nums) {
            if (seen.contains(i)) {
                seen.remove(i);
            } else {
                seen.add(i);
            }
        }
        int ans = 0;
        for (int i : seen) {
            ans = i;
        }
    }
    public int singleNumber(int[] nums) {
        int ans = 0;
        for (int i:nums) {
            ans ^= i;
        }
        return ans;
    }
}