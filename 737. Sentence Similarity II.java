/**
 * Union Find solution
 * Time O(P + N) where P is pairs.size() and N is words.length
 * Space O(P)
 */
class Solution {
    public boolean areSentencesSimilarTwo(String[] words1, String[] words2, List<List<String>> pairs) {
        if (words1.length != words2.length) return false;
        HashMap<String, Integer> map = new HashMap<>();
        UF uf = new UF(pairs.size()*2);
        for (List<String> l : pairs) {
            String l0 = l.get(0);
            String l1 = l.get(1);
            map.put(l0, map.getOrDefault(l0, map.size()));
            map.put(l1, map.getOrDefault(l1, map.size()));
            uf.union(map.get(l0), map.get(l1));
        }
        
        for (int i=0; i<words1.length; i++) {
            if (words1[i].equals(words2[i])) {
                continue;
            }
            if (!map.containsKey(words1[i]) || !map.containsKey(words2[i]) || !uf.find(map.get(words1[i]), map.get(words2[i]))) {
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