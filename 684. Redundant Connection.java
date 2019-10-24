class UF {
    int[] ids;
    public UF(int size) {
        ids = new int[size+1];
        for (int i=0;i<size+1;i++) {
            ids[i] = i;
        }
    }
    public int root(int A) {
        while (ids[A] != A) {
            ids[A] = ids[ids[A]];
            A = ids[A];
        }
        return A;
    }
    public boolean find(int A, int B) {
        return root(A) == root(B);
    }
    public void union(int A, int B) {
        int rA = root(A);
        int rB = root(B);
        ids[rA] = rB;
    }
}
class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        UF uf = new UF(edges.length);
        int[] saved = null;
        for (int[] pair : edges) {
            if (uf.find(pair[0], pair[1])) {
                saved = pair;
                break;
            }
            uf.union(pair[0], pair[1]);
        }
        return saved;
    }
}