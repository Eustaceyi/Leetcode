/**
 * greedy DFS & backtracking
 * point is using the return value of dfs to mark if found
 * Time: build graph O(V + ElogE) dfs+backtrack O(E)
 * Space: graph O(E) stack O(E) worst
 */
class Solution {
    List<String> ans;
    public List<String> findItinerary(List<List<String>> tickets) {
        HashMap<String, List<String>> graph = new HashMap<>();
        int edges = tickets.size();
        for (List<String> t : tickets) {
            if (!graph.containsKey(t.get(0))) {
                List<String> temp = new LinkedList<>();
                temp.add(t.get(1));
                graph.put(t.get(0), temp);
            } else {
                graph.get(t.get(0)).add(t.get(1));
            }
        }
        for (String key : graph.keySet()) {
            Collections.sort(graph.get(key));
        }
        backtrack("JFK", graph, new ArrayList<>(), edges);
        return ans;
    }
    private boolean backtrack(String curr, HashMap<String, List<String>> graph, List<String> ls, int edges) {
        ls.add(curr);
        if (ls.size() == edges+1) {
            ans = new ArrayList<>(ls);
            return true;
        }
        int size = 0;
        if (graph.containsKey(curr)) {
            size = graph.get(curr).size();
        }
        for (int i=0; i<size; i++) {
            String next = graph.get(curr).remove(0);
            if (backtrack(next, graph, ls, edges)) {
                return true;
            }
            graph.get(curr).add(next);
        }
        ls.remove(ls.size()-1);
        return false;
    }
}