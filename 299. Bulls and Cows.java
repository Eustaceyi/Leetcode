/**
 * One pass Solution
 * Time O(n)
 * Space O(n)
 */
class Solution {
    public String getHint(String secret, String guess) {
        int A=0, B=0;
        char[] s = secret.toCharArray(), g = guess.toCharArray();
        int[] digits = new int[10];
        for (int i=0; i<s.length; i++) {
            // this calculates the As
            if (s[i] == g[i]) {
                A++;
            } else { // this else ignores As
                if (digits[s[i]-'0']++ < 0) {B++;} // if the count of this char is neg, this means this char is shown in guess before
                if (digits[g[i]-'0']-- > 0) {B++;} // if the count of this char is pos, this means this chae is shown in secret before
            }
        }
        return A + "A" + B + "B";
    }
}