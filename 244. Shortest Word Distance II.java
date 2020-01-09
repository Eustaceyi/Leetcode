class WordDistance {
    private Map<String, List<Integer>> map;

    public WordDistance(String[] words) {
        map = new HashMap<>();
        for (int i=0; i<words.length; i++) {
            map.computeIfAbsent(words[i], (key->new ArrayList<>())).add(i);
        }
    }
    
    public int shortest(String word1, String word2) {
        List<Integer> l1 = map.get(word1), l2 = map.get(word2);
        int i1 = 0, i2 = 0;
        int ans = Integer.MAX_VALUE;
        while (i1 < l1.size() && i2 < l2.size()) {
            int il1 = l1.get(i1), il2 = l2.get(i2);
            ans = Math.min(ans, Math.abs(il1 - il2));
            if (il1 < il2) {
                i1++;
            } else {
                i2++;
            }
        }
        return ans;
    }
}

/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance obj = new WordDistance(words);
 * int param_1 = obj.shortest(word1,word2);
 */