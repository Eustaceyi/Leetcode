class HitCounter {
    Deque<Integer> dq;

    /** Initialize your data structure here. */
    public HitCounter() {
        dq = new ArrayDeque<>();
    }
    
    /** Record a hit.
        @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        dq.offer(timestamp);
    }
    
    /** Return the number of hits in the past 5 minutes.
        @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
        while (!dq.isEmpty() && dq.peekFirst() <= timestamp-300) {
            dq.pollFirst();
        }
        return dq.size();
    }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */