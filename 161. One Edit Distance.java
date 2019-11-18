class Solution {
    public boolean isOneEditDistance(String s, String t) {
        if (s.equals(t)) return false;
        if (Math.abs(s.length() - t.length()) > 1) {
            return false;
        }
        if (s.length() == t.length()) {
            boolean skip = false;
            for (int i=0; i<s.length(); i++) {
                if (s.charAt(i)!=t.charAt(i)) {
                    if (!skip) {
                        skip = true;
                    } else {
                        return false;
                    }
                }
            }
        } else {
            if (s.length() < t.length()) {
                String temp = t;
                t = s;
                s = temp;
            }
            boolean skip = false;
            for (int i=0; i<t.length(); i++) {
                if (skip) {
                    if (s.charAt(i+1)!=t.charAt(i)) {
                        return false;
                    }
                } else {
                    if (s.charAt(i)!=t.charAt(i)) {
                        skip = true;
                        i -= 1;
                    }
                }
            }
        }
        return true;
    }
}