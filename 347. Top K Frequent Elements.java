class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int i : nums) {
            count.put(i, count.getOrDefault(i, 0)+1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->(count.get(a)-count.get(b)));
        for (int key : count.keySet()) {
            pq.offer(key);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        return new ArrayList<>(pq);
    }
}