class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        if (s==null || s.length()<p.length()) {
            return ans;
        }
        int[] count = new int[26];
        for (char c : p.toCharArray()) {
            count[c-'a']++;
        }
        int start=0, end=0, pl=p.length(), diff=pl, sl=s.length();
        // build the window
        for (end=0; end<pl; end++) {
            char c = s.charAt(end);
            count[c-'a']--;
            if (count[c-'a']>=0) {
                diff--;
            }
        }
        if (diff==0) {
            ans.add(0);
        }
        while (end < sl) {
            char c = s.charAt(start);
            // if this is greater or equal to 0, this means that we need this char in the anagram
            if (count[c-'a']>=0) {
                diff++;    
            }
            count[c-'a']++;
            start++;
            c = s.charAt(end);
            count[c-'a']--;
            // if this is greater or equal to 0, this means that we need this char in the anagram
            if (count[c-'a']>=0) {
                diff--;
            }
            if (diff==0) {
                ans.add(start);
            }
            end++;
        }
        return ans;
    }
}