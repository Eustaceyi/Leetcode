class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        int[][] graph = new int[n][n];
        for (int[] fl : flights) {
            graph[fl[0]][fl[1]] = fl[2];
        }
        PriorityQueue<Tuple> pq = new PriorityQueue<>();
        pq.offer(new Tuple(src, 0, 0));
        while (!pq.isEmpty()) {
            Tuple t = pq.poll();
            if (t.stop-1 > K) {continue;}
            if (t.city == dst) {return t.price;}
            for (int i=0; i<n; i++) {
                if (graph[t.city][i] > 0) {
                    pq.offer(new Tuple(i, t.stop+1, t.price+graph[t.city][i]));
                }
            }
        }
        return -1;
    }
    
    class Tuple implements Comparable<Tuple> {
        int city;
        int stop;
        int price;
        public Tuple(int city, int stop, int price) {
            this.city = city;
            this.stop = stop;
            this.price = price;
        }
        @Override
        public int compareTo(Tuple that) {
            return this.price - that.price;
        }
    }
}