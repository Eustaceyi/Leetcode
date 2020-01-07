/**
 * every time we want to pick two small sticks and combine them,
 * so we use a heap to keep this
 * Time O(log(N!))
 * Space O(N)
 */
class Solution {
    public int connectSticks(int[] sticks) {
        int cost = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int s : sticks) {
            pq.offer(s);
        }
        while (pq.size() > 1) {
            int t1 = pq.poll();
            int t2 = pq.poll();
            cost += t1 + t2;
            pq.offer(t1+t2);
        }
        return cost;
    }
}