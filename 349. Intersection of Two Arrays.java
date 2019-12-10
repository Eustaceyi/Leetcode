class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<>();
        for (int i : nums1) {
            set.add(i);
        }
        HashSet<Integer> ls = new HashSet<>();
        for (int i : nums2) {
            if (set.contains(i)) {
                ls.add(i);
            }
        }
        int[] ans = new int[ls.size()];
        int index = 0;
        for (int i : ls) {
            ans[index++] = i;
        }
        return ans;
    }
}