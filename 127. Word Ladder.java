import javafx.util.Pair;
class Solution {
    HashMap<String, List<String>> graph;
    HashSet<String> wl;
    int len;
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        wl = new HashSet<>(wordList);
        wl.add(beginWord);
        if (!wl.contains(endWord)) {
            return 0;
        }
        len = beginWord.length();
        buildGraph();
        Deque<Pair<String, Integer>> dq = new ArrayDeque<>();
        dq.offer(new Pair<>(beginWord, 1));
        HashSet<String> seen = new HashSet<>();
        seen.add(beginWord);
        while (!dq.isEmpty()) {
            Pair<String, Integer> p = dq.poll();
            if (p.getKey().equals(endWord)) {
                return p.getValue();
            }
            int step = p.getValue();
            for (String next : graph.get(p.getKey())) {
                if (!seen.contains(next)) {
                    dq.offer(new Pair<>(next, step+1));
                    seen.add(next);
                }
            }
        }
        return 0;
    }
    private void buildGraph() {
        graph = new HashMap<>();
        for (String s : wl) {
            graph.put(s, new ArrayList<>());
            for (int i=0; i<len; i++) {
                for (int j=0; j<26; j++) {
                    String temp = s.substring(0, i) + (char)('a'+j) + s.substring(i+1);
                    if (wl.contains(temp) && !s.equals(temp)) {
                        graph.get(s).add(temp);
                    }
                }
            }
        }
    }
}