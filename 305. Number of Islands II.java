class Solution {
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        UF uf = new UF(m*n);
        List<Integer> ans = new ArrayList<>();
        for (int[] pos : positions) {
            int r=pos[0], c=pos[1];
            uf.add(r*n+c);
            if (r > 0 && uf.id[(r-1)*n+c] >= 0) {
                uf.union(r*n+c, (r-1)*n+c);
            }
            if (r < m-1 && uf.id[(r+1)*n+c] >= 0) {
                uf.union(r*n+c, (r+1)*n+c);
            }
            if (c > 0 && uf.id[r*n+c-1] >= 0) {
                uf.union(r*n+c, r*n+c-1);
            }
            if (c < n-1 && uf.id[r*n+c+1] >= 0) {
                uf.union(r*n+c, r*n+c+1);
            }
            ans.add(uf.count);
        }
        return ans;
    }
}
class UF {                          
    public int[] id, size;
    public int count;
    public UF(int n) {
        id = new int[n];
        size = new int[n];
        Arrays.fill(id, -1);
        Arrays.fill(size, 1);
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
        if (x != y) {
            if (size[x] > size[y]) {
                id[y] = x;
                size[x] += size[y];
            } else {
                id[x] = y;
                size[y] += size[x];
            }
            count--;
        }
    }
    
    public void add(int A) {
        if (id[A] < 0) {
            id[A] = A;
            count++;
        }
    }
}