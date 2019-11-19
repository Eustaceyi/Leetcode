class Solution {
    public String convertToTitle(int n) {
        HashMap<Integer, Character> int2char = new HashMap<>();
        for (int i=0; i<26; i++) {
            int2char.put(i, (char)('A'+i));
        }
        StringBuilder sb = new StringBuilder();
        while (n != 0) {
            n = n-1;
            sb.append(int2char.get(n % 26));
            n = n / 26;
        }
        sb.reverse();
        return sb.toString();
    }
}