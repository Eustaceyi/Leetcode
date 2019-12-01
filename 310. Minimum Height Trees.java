class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        for (int i=0; i<n; i++) {
            graph.put(i, new ArrayList<>());
        }
        for (int[] e : edges) {
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }
        Deque<Integer> dq = new ArrayDeque<>();
        for (int i=0; i<n; i++) {
            if (graph.get(i).size() == 1) {
                dq.offer(i);
            }
        }
        while (graph.size() > 2) {
            int size = dq.size();
            for (int i=0; i<size; i++) {
                int curr = dq.poll();
                int nei = graph.get(curr).get(0);
                graph.get(nei).remove(new Integer(curr));
                if (graph.get(nei).size() == 1) {
                    dq.offer(nei);
                }
                graph.remove(curr);
            }
        }
        List<Integer> ans = new ArrayList<>();
        for (int i : graph.keySet()) {
            ans.add(i);
        }
        return ans;
    }
}