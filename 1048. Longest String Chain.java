class Solution {
    public int longestStrChain(String[] words) {
        HashMap<Integer, List<String>> map = new HashMap<>();
        for (String w : words) {
            List<String> temp = map.getOrDefault(w.length(), new ArrayList<>());
            temp.add(w);
            map.put(w.length(), temp);
        }
        int ans = 0;
        for (String w : words) {
            ans = Math.max(ans, helper(w, map));
        }
        return ans;
    }
    private int helper(String w, HashMap<Integer, List<String>> map) {
        int len = w.length();
        List<String> ls = map.get(len-1);
        if (ls == null) {
            return 1;
        } else {
            int max = 1;
            for (String word : ls) {
                if (check(w, word)) {
                    max = Math.max(helper(word, map)+1, max);
                }
            }
            return max;
        }
    }
    
    private boolean check(String w1, String w2) {
        int p=0;
        boolean skip=false;
        while (p<w2.length()) {
            if (skip) {
                if (w1.charAt(p+1) != w2.charAt(p)) {
                    return false;
                }
            } else {
                if (w1.charAt(p) != w2.charAt(p)) {
                    skip = true;
                    p--;
                } 
            }
            p++;
        }
        return true;
    }
}