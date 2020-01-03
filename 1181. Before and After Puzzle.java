class Solution {
    class Tuple {
        String[] s;
        int index;
        public Tuple(String[] s, int index) {
            this.s = s;
            this.index = index;
        }
        public String toString() {
            return Arrays.toString(s) + " " + index;
        }
    }
    public List<String> beforeAndAfterPuzzles(String[] phrases) {
        HashMap<String, List<Tuple>> before = new HashMap<>();
        HashMap<String, List<Tuple>> after = new HashMap<>();
        for (int i=0; i<phrases.length; i++) {
            String phrase = phrases[i];
            String[] ph = phrase.split(" ");
            List<Tuple> be = before.getOrDefault(ph[ph.length-1], new ArrayList<>());
            be.add(new Tuple(Arrays.copyOfRange(ph, 0, ph.length-1), i));
            before.put(ph[ph.length-1], be);
            
            List<Tuple> af = after.getOrDefault(ph[0], new ArrayList<>());
            af.add(new Tuple(ph, i));
            after.put(ph[0], af);
        }
        Set<String> ans = new TreeSet<>();
        for (String b : before.keySet()) {
            if (after.containsKey(b)) {
                for (Tuple t : before.get(b)) {
                    for (Tuple tt : after.get(b)) {
                        if (t.index != tt.index) {
                            StringBuilder sb = new StringBuilder();
                            for (String s : t.s) {
                                sb.append(s);
                                sb.append(" ");
                            }
                            for (String s : tt.s) {
                                sb.append(s);
                                sb.append(" ");
                            }
                            sb.deleteCharAt(sb.length()-1);
                            ans.add(sb.toString());
                        }
                    }
                }
            }
        }
        List<String> res = new ArrayList<>(ans);
        return res;
    }
}