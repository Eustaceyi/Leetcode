import javafx.util.*;
class Solution {
    public String minWindow(String s, String t) {
        if (s.length()==0 || t.length()==0) {
            return "";
        }
        List<Pair<Integer, Character>> map = new ArrayList<>();
        HashMap<Character, Integer> tmap = new HashMap<>();
        for (char c : t.toCharArray()) {
            tmap.put(c, tmap.getOrDefault(c, 0)+1);
        }
        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if (tmap.containsKey(c)) {
                map.add(new Pair<>(i, c));
            }
        }
        int st=-1, ed=s.length();
        int l=0, r=0;
        int required = tmap.size(), formed=0;
        HashMap<Character, Integer> count = new HashMap<>();
        while (r < map.size()) {
            char c = map.get(r).getValue();
            count.put(c, count.getOrDefault(c, 0)+1);
            if (tmap.containsKey(c) && count.get(c).intValue() == tmap.get(c).intValue()) {
                formed++;
            }
            while (l <= r && formed==required) {
                c = map.get(l).getValue();
                int end = map.get(r).getKey();
                int start = map.get(l).getKey();
                if (end-start+1 < ed-st+1) {
                    ed = end;
                    st = start;
                }
                
                count.put(c, count.get(c)-1);
                if (tmap.containsKey(c) && count.get(c).intValue() < tmap.get(c).intValue()) {
                    formed--;
                }
                l++;
            }
            r++;
        }
        return ed-st > s.length()? "" : s.substring(st, ed+1);
    }
}