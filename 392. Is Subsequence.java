/**
 * two pointer for finding the sequence
 */
class Solution {
    public boolean isSubsequence(String s, String t) {
        if (s==null || s.length()==0) {
            return true;
        }
        int ps = 0, pt = 0;
        while (pt < t.length()) {
            if (t.charAt(pt) == s.charAt(ps)) {
                ps++;
            }
            if (ps == s.length()) {
                return true;
            }
            pt++;
        }
        return false;
    }
}
/**
 * using the inbuilt indexOf() method
 */
class Solution {
    public boolean isSubsequence(String s, String t) {
        int index  = 0;
        for (int i=0; i<s.length(); i++) {
            index = t.indexOf(s.charAt(i), index)+1;
            if (index == 0) {
                return false;
            }
        }
        return true;
    }
}