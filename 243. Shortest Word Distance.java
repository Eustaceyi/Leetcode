/**
 * we could store the index of both words in vars that could 
 * help with calculate the min distance, since we don't need to 
 * check along all words.
 * Time O(n) Space O(1)
 */
class Solution {
    public int shortestDistance(String[] words, String word1, String word2) {
        int i1 = -1, i2 = -1;
        int minDist = Integer.MAX_VALUE;
        for (int i=0; i<words.length; i++) {
            if (words[i].equals(word1)) {
                i1 = i;
                if (i2 >= 0) {
                    minDist = Math.min(minDist, i1-i2);
                }
            }
            if (words[i].equals(word2)) {
                i2 = i;
                if (i1 >= 0) {
                    minDist = Math.min(minDist, i2-i1);
                }
            }
        }
        return minDist;
    }
}