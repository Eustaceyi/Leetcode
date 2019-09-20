class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int start = 0;
        int end = 0;
        int result = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        while (end < n) {
            char c = s.charAt(end);
            if (map.containsKey(c) && map.get(c) >= start) {
                start = map.get(c)+1;
            }
            map.put(c, end);
            end++;
            result = Math.max(result, end-start);
        }
        return result;
    }
}