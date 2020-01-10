class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strings) {
            boolean flag = true;
            for (String ss : map.keySet()) {
                if (ss.length() == s.length()) {
                    if (check(s, ss)) {
                        flag = false;
                        map.get(ss).add(s);
                        break;
                    }
                }
            }
            if (flag) {
                List<String> toadd = new ArrayList<>();
                toadd.add(s);
                map.put(s, toadd);
            }
        }
        List<List<String>> ans = new ArrayList<>();
        for (List<String> t : map.values()) {
            ans.add(t);
        }
        return ans;
    }
    
    private boolean check(String w1, String w2) {
        char[] cw1 = w1.toCharArray();
        char[] cw2 = w2.toCharArray();
        int diff = cw1[0] - cw2[0];
        for (int i=1; i<cw1.length; i++) {
            char newc = (char)(cw2[i] + diff);
            if (newc > 'z') {
                newc -= 26;
            } else if (newc < 'a') {
                newc += 26;
            }
            if (newc != cw1[i]) {
                return false;
            }
        }
        return true;
    }
}
/**
 * Use hash to compute the relative distance to the first char
 * then use this hashcode to find group
 */
class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strings) {
            String hashcode = hash(s);
            map.putIfAbsent(hashcode, new ArrayList<>());
            map.get(hashcode).add(s);
        }
        List<List<String>> ans = new ArrayList<>();
        for (List<String> t : map.values()) {
            ans.add(t);
        }
        return ans;
    }
    
    private String hash(String w) {
        StringBuilder sb = new StringBuilder();
        char c = w.charAt(0);
        for (int i=0; i<w.length(); i++) {
            int diff = w.charAt(i) - c;
            if (diff < 0) {
                diff = 26 + diff;
            }
            sb.append(diff).append('-');
        }
        return sb.toString();
    }
}