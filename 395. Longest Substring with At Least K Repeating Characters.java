public class Solution {
    public int longestSubstring(String s, int k) {
        if (s == null || s.length() == 0) return 0;
        char[] chars = new char[26];
        // record the frequency of each character
        for (int i = 0; i < s.length(); i += 1) chars[s.charAt(i) - 'a'] += 1;
        boolean flag = true;
        for (int i = 0; i < chars.length; i += 1) {
            if (chars[i] < k && chars[i] > 0) flag = false;
        }
        // return the length of string if this string is a valid string
        if (flag == true) return s.length();
        int result = 0;
        int start = 0, cur = 0;
        // otherwise we use all the infrequent elements as splits
        while (cur < s.length()) {
            if (chars[s.charAt(cur) - 'a'] < k) {
                result = Math.max(result, longestSubstring(s.substring(start, cur), k));
                start = cur + 1;
            }
            cur++;
        }
        result = Math.max(result, longestSubstring(s.substring(start), k));
        return result;
    }
}

class Solution {
    public int longestSubstring(String s, int k) {
        int ans = 0;
        int[] count = new int[26];
        for (int u=1; u<=26; u++) {
            Arrays.fill(count,0);
            int left=0, right=0, unique=0, kOrMore=0;
            while (right < s.length()) {
                if (unique <= u) {
                    char c = s.charAt(right);
                    count[c-'a']++;
                    if (count[c-'a'] == 1) {
                        unique++;
                    }
                    if (count[c-'a'] == k) {
                        kOrMore++;
                    }
                    right++;
                } else {
                    char c = s.charAt(left);
                    count[c-'a']--;
                    if (count[c-'a'] == 0) {
                        unique--;
                    }
                    if (count[c-'a'] == k-1) {
                        kOrMore--;
                    }
                    left++;
                }
                if (unique == u && u == kOrMore) {
                    ans = Math.max(ans, right-left);
                }
            }
        }
        return ans;
    }
}

class Solution {
    public int longestSubstring(String s, int k) {
        return ls(s, k, 0, s.length());
    }
    
    private int ls(String s, int k, int st, int ed) {
        if (st >= ed) {
            return 0;
        }
        HashMap<Character, List<Integer>> map = new HashMap<>();
        for (int i = st; i < ed; i++) {
            char c = s.charAt(i);
            map.computeIfAbsent(c, (key->new ArrayList<>())).add(i);
        }
        Set<Integer> notUsing = new TreeSet<>();
        for (List<Integer> l : map.values()) {
            if (l.size() < k) {
                for (int i : l) {
                    notUsing.add(i);
                }
            }
        }
        if (notUsing.size() == ed - st) {
            return 0;
        }
        if (notUsing.size() == 0) {
            return ed - st;
        }
        int toRet = Integer.MIN_VALUE;
        int last = -1;
        for (int i : notUsing) {
            toRet = Math.max(toRet, ls(s, k, last+1, i));
            last = i;
        }
        toRet = Math.max(toRet, ls(s, k, last+1, ed));
        return toRet;
    }
}