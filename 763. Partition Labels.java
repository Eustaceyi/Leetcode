class Solution {
    public List<Integer> partitionLabels(String S) {
        Map<Character, Integer> lastOccur = new HashMap<>();
        for (int i=0; i<S.length(); i++) {
            lastOccur.put(S.charAt(i), i);
        }
        List<Integer> ans = new ArrayList<>();
        int start=0, end=0;
        for (int i=0; i<S.length(); i++) {
            end = Math.max(end, lastOccur.get(S.charAt(i)));
            if (end == i) {
                ans.add(end-start+1);
                start = end+1;
            }
        }
        return ans;
    }
}