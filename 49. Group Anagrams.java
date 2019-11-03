/**
 * Sorting each word and put into a hashmap
 * Time O(nklogk)
 * Space O(nk)
 */
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] cstr = str.toCharArray();
            Arrays.sort(cstr);
            String sstr = new String(cstr);
            if (map.containsKey(sstr)) {
                map.get(sstr).add(str);
            } else {
                List<String> temp = new ArrayList<>();
                temp.add(str);
                map.put(sstr, temp);
            }
        }
        return new ArrayList(map.values());
    }
}
/**
 * Counting sort, other are same
 * Time O(nk)
 * Space O(nk)
 */
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            int[] count = new int[26];
            for (char c : str.toCharArray()) {
                count[c - 'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for (int i=0; i<26; i++) {
                sb.append('#');
                sb.append(count[i]);
            }
            String key = sb.toString();
            if (map.containsKey(key)) {
                map.get(key).add(str);
            } else {
                List<String> temp = new ArrayList<>();
                temp.add(str);
                map.put(key, temp);
            }
        }
        return new ArrayList(map.values());
    }
}