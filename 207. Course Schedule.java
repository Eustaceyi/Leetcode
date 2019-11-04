/**
 * Topological sort
 * Time O(V+E)
 * Space O(v+E)
 */
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] inDe = new int[numCourses];
        List<List<Integer>> outDe = new ArrayList<>();
        for (int i=0; i<numCourses; i++) {
            outDe.add(new ArrayList<>());
        }
        for (int[] path : prerequisites) {
            inDe[path[1]]++;
            outDe.get(path[0]).add(path[1]);
        }
        Deque<Integer> dq = new ArrayDeque<>();
        HashSet<Integer> seen = new HashSet<>();
        for (int i=0; i<numCourses; i++) {
            if (inDe[i] == 0) {
                dq.offer(i);
            }
        }
        while (!dq.isEmpty()) {
            int curr = dq.poll();
            seen.add(curr);
            for (int i : outDe.get(curr)) {
                inDe[i]--;
                if (inDe[i] == 0) {
                    dq.offer(i);
                }
            }
        }
        return seen.size() == numCourses;
    }
}