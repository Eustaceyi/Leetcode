class Solution {
    public int shortestWordDistance(String[] words, String word1, String word2) {
        if (word1.equals(word2)) {
            int pos = -1;
            int minlen = Integer.MAX_VALUE;
            for (int i=0; i<words.length; i++) {
                String word = words[i];
                if (word.equals(word1)) {
                    if (pos >= 0) {
                        minlen = Math.min(minlen, i-pos);
                    }
                    pos = i;
                }
            }
            return minlen;
        } else {
            int minlen = Integer.MAX_VALUE;
            int p1 = -1, p2 = -1;
            for (int i=0; i<words.length; i++) {
                String w = words[i];
                if (w.equals(word1)) {
                    p1 = i;
                    if (p2 >= 0) {
                        minlen = Math.min(minlen, p1-p2);
                    }
                }
                if (w.equals(word2)) {
                    p2 = i;
                    if (p1 >= 0) {
                        minlen = Math.min(minlen, p2-p1);
                    }
                }
            }
            return minlen;
        }
    }
}