/**
 * Dijkstra Algorithm
 * Build Graph Time O(E) Space O(E)
 * Search Time O(ElogE) Space O(V + E)
 */
class Solution {
    public int networkDelayTime(int[][] times, int N, int K) {
        if (times==null || times.length==0) {
            return -1;
        }
        Map<Integer, List<int[]>> graph = buildGraph(times);
        int[] time = new int[N];
        Arrays.fill(time, -1);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b)->(a[1]-b[1]));
        pq.offer(new int[] {K, 0});
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            if (time[curr[0]-1] >= 0) {continue;}
            time[curr[0]-1] = curr[1];
            if (graph.containsKey(curr[0])) {
                for (int[] t : graph.get(curr[0])) {
                    if (time[t[0]-1] == -1) {
                        pq.offer(new int[] {t[0], t[1]+curr[1]});
                    }
                }
            }
        }
        int max = 0;
        for (int i : time) {
            if (i == -1) {return -1;}
            max = Math.max(i, max);
        }
        return max;
    }
    
    private Map<Integer, List<int[]>> buildGraph(int[][] times) {
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] t : times) {
            graph.computeIfAbsent(t[0], key->new ArrayList<>()).add(new int[] {t[1], t[2]});
        }
        return graph;
    }
}