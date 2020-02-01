class Solution {
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        UF uf = new UF(s.length());
        for (List<Integer> ls : pairs) {
            uf.union(ls.get(0), ls.get(1));
        }
        Map<Integer, List<Integer>> pos = new HashMap<>();
        Map<Integer, List<Character>> chars = new HashMap<>();
        for (int i=0; i<s.length(); i++) {
            pos.computeIfAbsent(uf.root(i), key -> new ArrayList<>()).add(i);
            chars.computeIfAbsent(uf.root(i), key -> new ArrayList<>()).add(s.charAt(i));
        }
        char[] ans = new char[s.length()];
        for (int i : pos.keySet()) {
            List<Integer> ind = pos.get(i);
            List<Character> chs = chars.get(i);
            Collections.sort(ind);
            Collections.sort(chs);
            for (int p=0; p<ind.size(); p++) {
                ans[ind.get(p)] = chs.get(p);
            }
        }
        return new String(ans);
    }
}

class UF {
    private int[] id, size;
    
    public UF(int n) {
        id = new int[n];
        size = new int[n];
        for (int i=0; i<n; i++) {
            id[i] = i;
            size[i] = 1;
        }
    }
    
    public int root(int A) {
        while (id[A] != A) {
            id[A] = id[id[A]];
            A = id[A];
        }
        return A;
    }
    
    public boolean find(int A, int B) {
        return root(A) == root(B);
    }
    
    public void union(int A, int B) {
        int a = root(A);
        int b = root(B);
        if (a != b) {
            if (size[a] > size[b]) {
                id[b] = a;
                size[a] += size[b];
            } else {
                id[a] = b;
                size[b] += size[a];
            }
        }
    }
}