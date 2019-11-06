/**
 * BFS solution
 * build graph O(V+E) traverse O(V+E)
 * Space O(V+E)
 * change queue to stack will change into DFS
 */
class Solution {
    public boolean validTree(int n, int[][] edges) {
        if (edges.length != n-1) {
            return false;
        }
        List<List<Integer>> graph = new ArrayList<>();
        for (int i=0; i<n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] e : edges) {
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }
        HashSet<Integer> seen = new HashSet<>();
        Deque<Integer> dq = new ArrayDeque<>();
        dq.offer(0);
        seen.add(0);
        while (!dq.isEmpty()) {
            int curr = dq.poll();
            for (int next : graph.get(curr)) {
                if (!seen.contains(next)) {
                    dq.offer(next);
                    seen.add(next);
                }
            }
        }
        return seen.size() == n;
    }
}

/**
 * Union find
 * Time O(E * (find + union) + V * root)
 * Space O(V)
 */
class Solution {
    public boolean validTree(int n, int[][] edges) {
        if (edges.length != n-1) {
            return false;
        }
        UF uf = new UF(n);
        for (int[] e : edges) {
            if (uf.find(e[0], e[1])) {
                return false;
            } else {
                uf.union(e[0], e[1]);
            }
        }
        int root = uf.root(0);
        for (int i=1; i<n;i++) {
            if (uf.root(i) != root){
                return false;
            }
        }
        return true;
    }
}

class UF {
    int[] id;
    int[] size;
    public UF(int n) {
        id = new int[n];
        size = new int[n];
        for (int i=0;i<n;i++) {
            id[i] = i;
            size[i] = 1;
        }
    }
    public int root(int A) {
        while (A != id[A]) {
            id[A] = id[id[A]];
            A = id[A];
        }
        return A;
    }
    public boolean find(int A, int B) {
        return root(A) == root(B);
    }
    public void union(int A, int B) {
        int x = root(A);
        int y = root(B);
        if (size[x] > size[y]) {
            id[y] = x;
        } else {
            id[x] = y;
        }
    }
}