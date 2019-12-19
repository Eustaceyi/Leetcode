class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        HashMap<Character,Integer> map = new HashMap<>();
        for (int i=0; i<order.length(); i++) {
            map.put(order.charAt(i), i);
        }
        for (int i=0; i<words.length-1; i++) {
            int pa = 0, pb = 0;
            String a = words[i];
            String b = words[i+1];
            while (pa < a.length() && pb < b.length()) {
                int temp = map.get(a.charAt(pa)) - map.get(b.charAt(pb));
                if (temp > 0) {
                    return false;
                } else if (temp < 0) {
                    break;
                } else {
                    pa++; pb++;
                }
            }
            if (pb == b.length() && pa != a.length()) {
                return false;
            }
        }
        return true;
    }
}