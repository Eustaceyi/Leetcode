/**
 * 1. keep three pointers of p2, p3, p5, and the next ugly number will be either ans[p2]*2, ans[p3]*3, ans[p5]*5
 * 2. use static field to create the cache when the class is build, this could improve the time
 */
class Ugly {
    public int[] ans = new int[1690]; 
    public Ugly() {
        ans[0]=1;
        int p2=0, p3=0, p5=0;
        for (int i=1; i<1690; i++) {
            int n2 = 2*ans[p2];
            int n3 = 3*ans[p3];
            int n5 = 5*ans[p5];
            int m = Math.min(n2, Math.min(n3, n5));
            ans[i] = m;
            if (m==n2) {p2++;}
            if (m==n3) {p3++;}
            if (m==n5) {p5++;}
        }
    }
}

class Solution {
    private static Ugly u = new Ugly();
    public int nthUglyNumber(int n) {
        return u.ans[n-1];
    }
}