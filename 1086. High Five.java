class Solution {
    public int[][] highFive(int[][] items) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int[] a : items) {
            int id = a[0], score = a[1];
            if (map.containsKey(id)) {
                map.get(id).add(score);
            } else {
                List<Integer> temp = new ArrayList<>();
                temp.add(score);
                map.put(id, temp);
            }
        }
        int[][] ans = new int[map.keySet().size()][2];
        int count = 0;
        for (Map.Entry<Integer, List<Integer>> e : map.entrySet()) {
            List<Integer> temp = e.getValue();
            Collections.sort(temp, Collections.reverseOrder());
            List<Integer> five = temp.subList(0, 5);
            int sum = 0;
            for (int i : five) {
                sum += i;
            }
            sum /= 5;
            ans[count++] = new int[] {e.getKey(), sum};
        }
        return ans;
    }
}