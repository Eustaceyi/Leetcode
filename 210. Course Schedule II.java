/**
 * topological sort
 * Time O(V+E)
 * Space O(V+E)
 */
class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] inDe = new int[numCourses];
        List<List<Integer>> outDe = new ArrayList<>();
        for (int i=0; i<numCourses; i++) {
            outDe.add(new ArrayList<>());
        }
        for (int[] pair : prerequisites) {
            inDe[pair[0]]++;
            outDe.get(pair[1]).add(pair[0]);
        }
        Deque<Integer> dq = new ArrayDeque<>();
        for (int i=0; i<numCourses; i++) {
            if (inDe[i]==0) {
                dq.offer(i);
            }
        }
        List<Integer> ans = new ArrayList<>();
        while (!dq.isEmpty()) {
            int curr = dq.poll();
            ans.add(curr);
            for (int next : outDe.get(curr)) {
                inDe[next]--;
                if (inDe[next]==0) {
                    dq.offer(next);
                }
            }
        }
        int[] ret = new int[numCourses];
        if (ans.size() != numCourses) {
            return new int[0];
        } else {
            for (int i=0; i<numCourses; i++) {
                ret[i] = ans.get(i);
            }
        }
        return ret;
    }
}