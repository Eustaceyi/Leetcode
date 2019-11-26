class Solution {
    public boolean isAnagram(String s, String t) {
        if (s==null && t==null) {
            return true;
        } else if (s==null || t==null) {
            return false;
        }
        if (s.length() != t.length()) {
            return false;
        }
        int[] smap = new int[26];
        int[] tmap = new int[26];
        for (int i=0; i<s.length(); i++) {
            smap[s.charAt(i)-'a']++;
            tmap[t.charAt(i)-'a']++;
        }
        for (int i=0; i<26; i++) {
            if (smap[i]!=tmap[i]) {
                return false;
            }
        }
        return true;
    }
}