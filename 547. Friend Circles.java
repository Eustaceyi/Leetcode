/**
 * Union find solution 
 * Time O(n^2)
 * Space O(n)
 */
class Solution {
    public int findCircleNum(int[][] M) {
        if (M==null || M.length==0) {
            return 0;
        }
        int n = M.length;
        WQUPC uf =  new WQUPC(n);
        for (int i=0; i<n; i++) {
            for (int j=i+1; j<n; j++) {
                if (M[i][j] == 1) {
                    uf.union(i,j);
                }
            }
        }
        HashSet<Integer> set = new HashSet<>();
        for (int i=0; i<n; i++) {
            set.add(uf.root(i));
        }
        return set.size();
    }
}

class WQUPC {
    int[] id;
    int[] size;
    public WQUPC(int n) {
        id = new int[n];
        size = new int[n];
        for (int i=0; i<n; i++) {
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
            size[x] += size[y];
        } else {
            id[x] = y;
            size[y] += size[x];
        }
    }
}
/**
 * DFS solution
 * Time O(n^2)
 * Space O(n)
 */
public class Solution {
    public void dfs(int[][] M, int[] visited, int i) {
        for (int j = 0; j < M.length; j++) {
            if (M[i][j] == 1 && visited[j] == 0) {
                visited[j] = 1;
                dfs(M, visited, j);
            }
        }
    }
    public int findCircleNum(int[][] M) {
        int[] visited = new int[M.length];
        int count = 0;
        for (int i = 0; i < M.length; i++) {
            if (visited[i] == 0) {
                dfs(M, visited, i);
                count++;
            }
        }
        return count;
    }
}