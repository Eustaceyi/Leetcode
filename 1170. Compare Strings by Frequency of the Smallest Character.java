class Solution {
    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int[] q = new int[queries.length];
        int[] w = new int[12];
        for (int i=0; i<words.length; i++) {
            w[count(words[i])]++;
        }
        for (int i=10; i>=0; i--) {
            w[i] += w[i+1];
        }
        for (int i=0; i<q.length; i++) {
            int len = count(queries[i]);
            q[i] = w[len+1];
        }
        return q;
    }
    
    private int count(String word) {
        char smallest = 'z';
        for (char c : word.toCharArray()) {
            if (c < smallest) {
                smallest = c;
            }
        }
        int count = 0;
        for (char c : word.toCharArray()) {
            if (c == smallest) {
                count++;
            }
        }
        return count;
    }
}