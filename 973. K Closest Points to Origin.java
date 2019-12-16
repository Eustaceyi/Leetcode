/**
 * This is a heap solution, time O(nlogk)
 * there is another quick select answer, add later.
 */
class Solution {
    public int[][] kClosest(int[][] points, int K) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b)->(-a[0]*a[0]-a[1]*a[1]+b[0]*b[0]+b[1]*b[1]));
        for (int[] p : points) {
            pq.offer(p);
            if (pq.size() > K) {
                pq.poll();
            }
        }
        int[][] ans = new int[K][2];
        int count = 0;
        while (!pq.isEmpty()) {
            ans[count++] = pq.poll();
        }
        return ans;
    }
}