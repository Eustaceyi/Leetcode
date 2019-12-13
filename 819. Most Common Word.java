class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        String[] p = paragraph.toLowerCase().split("[ !?',;.]+");
        Map<String, Integer> map = new HashMap<>();
        for (String s : p) {
            map.put(s, map.getOrDefault(s, 0)+1);
        }
        for (String b : banned) {
            map.remove(b);
        }
        int count = 0;
        String word = "";
        for (String w : map.keySet()) {
            int temp = map.get(w);
            if (temp > count) {
                count = temp;
                word = w;
            }
        }
        return word;
    }
}