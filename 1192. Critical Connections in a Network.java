/**
 * for a undirected graph, if we want to find "bridges" in the graph
 * we could do a dfs search, in this search, we need to record the time we
 * first meet a node and try to find out if there is any neighbor that have not been
 * seen through other path.
 * See: http://www.cs.umd.edu/class/fall2017/cmsc451-0101/Lects/lect04-edge-connectivity.pdf
 * also https://leetcode.com/problems/critical-connections-in-a-network/discuss/382632/Java-implementation-of-Tarjan-Algorithm-with-explanation
 */
class Solution {
    int time;
    public Solution() {
        time = 0;
    }
    
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        int[] disc = new int[n];
        int[] low = new int[n];
        Arrays.fill(disc, -1);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer>[] graph = new List[n];
        for (int i=0; i<n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for (List<Integer> con : connections) {
            graph[con.get(0)].add(con.get(1));
            graph[con.get(1)].add(con.get(0));
        }
        
        for (int i=0; i<n; i++) {
            if (disc[i]==-1) {
                DFS(i, disc, low, ans, graph, i);
            }
        }
        return ans;
    }
    
    private void DFS(int node, int[] disc, int[] low, List<List<Integer>> ans, List<Integer>[] graph, int par) {
        disc[node] = low[node] = time++;
        for (int nei : graph[node]) {
            if (nei == par) {continue;}
            if (disc[nei] == -1) {
                DFS(nei, disc, low, ans, graph, node);
                low[node] = Math.min(low[node], low[nei]);
                if (low[nei] > disc[node]) {
                    ans.add(Arrays.asList(node, nei));
                }
            } else {
                low[node] = Math.min(low[node], disc[nei]);
            }
        }
    }
}