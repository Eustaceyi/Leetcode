/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */
/**
 * in the first loop we want to have a candidate, that is to check 
 * if the curr knows the candidate,
 * if knows, curr becomes candidate
 * else next person
 * 
 * and then we check if all people knows candidate and candidate knows nobody
 */
public class Solution extends Relation {
    public int findCelebrity(int n) {
        int can = 0;
        for (int i=1; i<n; i++) {
            if (knows(can, i)) {
                can = i;
            }
        }
        for (int i=0; i<n; i++) {
            if (i==can) continue;
            if (!knows(i, can) || knows(can, i)) {
                return -1;
            }
        }
        return can;
    }
}