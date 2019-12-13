class Solution {
    class Tuple implements Comparable<Tuple> {
        String word;
        int count;
        Tuple(String word, int count) {
            this.word = word;
            this.count = count;
        }
        @Override
        public int compareTo(Tuple that) {
            if (this.count != that.count) {
                return this.count - that.count;
            } else {
                 return that.word.compareTo(this.word);
            }
        }
    }
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> count = new HashMap<>();
        for (String w : words) {
            count.put(w, count.getOrDefault(w, 0)+1);
        }
        PriorityQueue<Tuple> pq = new PriorityQueue<>();
        for (String word : count.keySet()) {
            pq.offer(new Tuple(word, count.get(word)));
            if (pq.size() > k) {
                pq.poll();
            }
        }
        LinkedList<String> ans = new LinkedList<>();
        while (!pq.isEmpty()) {
            ans.addFirst(pq.poll().word);
        }
        return ans;
    }
}