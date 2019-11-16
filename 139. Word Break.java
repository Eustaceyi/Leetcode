class Solution {
    List<String> wordDict;
    public boolean wordBreak(String s, List<String> wordDict) {
        HashMap<String, Boolean> memo = new HashMap<>();
        this.wordDict = wordDict;
        return dfs(s, memo);
    }
    public boolean dfs(String s, HashMap<String, Boolean> memo) {
        if (s==null || s.length()==0) {
            return true;
        }
        if (memo.containsKey(s)) {
            return memo.get(s);
        }
        for (String w : wordDict) {
            if (s.startsWith(w)) {
                boolean res = dfs(s.substring(w.length()), memo);
                if (res) {
                    memo.put(s, true);
                    return true;
                }
            }
        }
        memo.put(s, false);
        return false;
    }
}