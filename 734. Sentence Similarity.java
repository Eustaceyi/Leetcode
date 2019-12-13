class Solution {
    public boolean areSentencesSimilar(String[] words1, String[] words2, List<List<String>> pairs) {
        if (words1.length != words2.length) {
            return false;
        }
        HashMap<String, Set<String>> map = new HashMap<>();
        for (List<String> l : pairs) {
            String w1 = l.get(0);
            String w2 = l.get(1);
            if (map.containsKey(w1)) {
                map.get(w1).add(w2);
            } else {
                Set<String> set = new HashSet<>();
                set.add(w2);
                map.put(w1, set);
            }
            if (map.containsKey(w2)) {
                map.get(w2).add(w1);
            } else {
                Set<String> set = new HashSet<>();
                set.add(w1);
                map.put(w2, set);
            }
        }
        for (int i=0; i<words1.length; i++) {
            if (words1[i].equals(words2[i])) continue;
            if (!map.getOrDefault(words1[i], new HashSet<>()).contains(words2[i]) ||
               !map.getOrDefault(words2[i], new HashSet<>()).contains(words1[i])) {
                return false;
            }
        }
        return true;
    }
}