class Solution {
    /**
     * Event for using in priority queue
     */
    class Event implements Comparable<Event>{
        long pos;
        int hei;
        public Event(long pos, int hei) {
            this.pos = pos;
            this.hei = hei;
        }
        public int compareTo(Event that) {
            return that.hei - this.hei;
        }
        public String toString() {
            return "[" + pos + "," + hei + "]";
        }
    }
    
    public List<List<Integer>> getSkyline(int[][] buildings) {
        PriorityQueue<Event> pq = new PriorityQueue<>();
        List<int[]> es = new ArrayList<>();
        for (int[] bs : buildings) {
            es.add(bs);
            es.add(new int[] {bs[1], 0, 0});
        }
        // keep the raising and dropping event in order
        Collections.sort(es, (a,b)->{
            if (a[0] != b[0]) {
                return a[0] - b[0];
            } else {
                return b[2] - a[2];
            }
        });
        List<List<Integer>> ans = new ArrayList<>();
        pq.offer(new Event(Long.MAX_VALUE, 0));
        for (int[] e : es) {
            // if we meet a raising event, we push into pq
            if (e[2] > 0) {
                pq.offer(new Event((long)e[1], e[2]));
            } 
            // if the maxheight is not valid, pop it
            while(pq.peek().pos <= (long)e[0]) {
                pq.poll();
            }
            // if the height changed, we record a new point
            if (ans.size()==0 || ans.get(ans.size()-1).get(1) != pq.peek().hei) {
                List<Integer> temp = new ArrayList<>();
                temp.add(e[0]);
                temp.add(pq.peek().hei);
                ans.add(temp);
            }
        }
        return ans;
    }
}