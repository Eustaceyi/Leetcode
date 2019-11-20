/**
 * O(L*(N-L)) time solution where L is the length of requiring sequence
 * This solution uses O(L) time to get next seqence, this is slow.
 */
class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        if (s.length() <= 10) {
            return new ArrayList<>();
        }
        HashMap<String, Integer> seen = new HashMap<>();
        List<String> ans = new ArrayList<>();
        for (int i=0; i<=s.length()-10; i++) {
            String curr = s.substring(i, i+10);
            int count = seen.getOrDefault(curr, 0);
            if (count == 1) {
                ans.add(curr);
                seen.put(curr, 2);
            } else if (count == 0) {
                seen.put(curr, 1);
            }
        }
        return ans;
    }
}
/**
 * use rolling hash to keep the time of calculating sequence as O(1)
 */
class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        int n = s.length();
        Map<Character, Integer> map = new HashMap<>();
        map.put('A', 0);
        map.put('C', 1);
        map.put('G', 2);
        map.put('T', 3);
        int[] as = new int[n];
        int count = 0;
        for (char c : s.toCharArray()) {
            as[count++] = map.get(c);
        }
        int base = 4; int baseL = (int)Math.pow(base, 10);
        int hash = 0;
        Map<Integer, Integer> seen = new HashMap<>();
        List<String> ans = new ArrayList<>();
        for (int i=0; i<=n-10; i++) {
            if (i!=0) {
                hash = hash*base - as[i-1]*baseL + as[i+9];
            } else {
                for (int j=0; j<10; j++) {
                    hash = hash * base + as[j];
                }
            }
            count = seen.getOrDefault(hash, 0);
            if (count == 0) {
                seen.put(hash, 1);
            } else if (count == 1) {
                seen.put(hash, 2);
                ans.add(s.substring(i, i+10));
            }
        }
        return ans;
    }
}