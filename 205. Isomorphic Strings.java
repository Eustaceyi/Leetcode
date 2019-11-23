class Solution {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> stot = new HashMap<>();
        Map<Character, Character> ttos = new HashMap<>();
        for (int i=0; i<s.length(); i++) {
            char cs = s.charAt(i);
            char ct = t.charAt(i);
            if (stot.containsKey(cs)) {
                if (stot.get(cs) != ct) {
                    return false;
                }
            } else {
                stot.put(cs, ct);
            }
            if (ttos.containsKey(ct)) {
                if (ttos.get(ct) != cs) {
                    return false;
                }
            } else {
                ttos.put(ct, cs);
            }
        }
        return true;
    }
}

class Solution {
    public boolean isIsomorphic(String s, String t) {
        int[] stot = new int[256];
        int[] ttos = new int[256];
        for (int i=0; i<s.length(); i++) {
            char cs = s.charAt(i);
            char ct = t.charAt(i);
            if (stot[cs] != ttos[ct]) {
                return false;
            }
            stot[cs] = i+1;
            ttos[ct] = i+1;
        }
        return true;
    }
}