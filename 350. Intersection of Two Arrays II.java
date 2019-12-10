class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : nums1) {
            map.put(i, map.getOrDefault(i, 0)+1);
        }
        List<Integer> ls = new ArrayList<>();
        for (int i : nums2) {
            if (map.getOrDefault(i, 0) > 0) {
                ls.add(i);
                map.put(i, map.get(i)-1);
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