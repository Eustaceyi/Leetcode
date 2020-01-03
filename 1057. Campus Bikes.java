class Solution {
    public int[] assignBikes(int[][] workers, int[][] bikes) {
        // Notice that the Manhattan distance is between 0 and 2000, 
        // which means we can sort easily without even using priority queue
        int w = workers.length, b = bikes.length;
        int[] wo = new int[w], bi = new int[b];
        List<int[]>[] dists = new List[2001];
        Arrays.fill(wo, -1);
        Arrays.fill(bi, -1);
        for (int i = 0; i < w; i++) {
            for (int j = 0; j < b; j++) {
                int[] worker = workers[i];
                int[] bike = bikes[j];
                int dist = Math.abs(worker[0] - bike[0]) + Math.abs(worker[1] - bike[1]);
                if (dists[dist] == null) {
                    dists[dist] = new ArrayList<int[]>();
                }
                dists[dist].add(new int[]{i, j});
            }
        }
        int assigned = 0;
        for (int i = 0; i <= 2000 && assigned < w; i++) {
            if (dists[i] == null) continue;
            for (int[] pair : dists[i]) {
                if (wo[pair[0]] == -1 && bi[pair[1]] == -1) {
                    wo[pair[0]] = pair[1];
                    bi[pair[1]] = pair[0];
                    assigned++;
                }
            }
        }
        return wo;
    }
}

/**
 * TreeMap solution
 * didnot consider the restriction given
 */
class Solution {
    class Pair {
        int w;
        int b;
        public Pair(int w, int b) {
            this.w = w;
            this.b = b;
        }
    }
    public int[] assignBikes(int[][] workers, int[][] bikes) {
        if (workers==null || workers.length==0) {
            return new int[0];
        }
        Map<Integer, List<Pair>> p = new TreeMap<>();
        for (int i=0; i<workers.length; i++) {
            for (int j=0; j<bikes.length; j++) {
                int dist = Math.abs(workers[i][0] - bikes[j][0]) + Math.abs(workers[i][1] - bikes[j][1]);
                List<Pair> ls = p.getOrDefault(dist, new ArrayList<>());
                ls.add(new Pair(i, j));
                p.put(dist, ls);
            }
        }
        Set<Integer> seenW = new HashSet<>();
        Set<Integer> seenB = new HashSet<>();
        int[] ans = new int[workers.length];
        for (int d : p.keySet()) {
            List<Pair> l = p.get(d);
            for (Pair pair : l) {
                if (!seenW.contains(pair.w) && !seenB.contains(pair.b)) {
                    ans[pair.w] = pair.b;
                    seenW.add(pair.w);
                    seenB.add(pair.b);
                }
            }
        }
        return ans;
    }
}