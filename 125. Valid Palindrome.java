class Solution {
    public boolean isPalindrome(String s) {
        if (s==null || s.length()==0) {
            return true;
        }
        char[] cs = s.toLowerCase().toCharArray();
        int write = 0;
        for (int read=0; read<s.length(); read++) {
            if ((cs[read] - 'a' < 26 && cs[read] - 'a' >= 0)||(cs[read] - '0' < 10 && cs[read] - '0' >= 0)) {
                cs[write++] = cs[read];
            }
        }
        int st = 0, ed = write-1;
        while (st < ed) {
            if (cs[st++] != cs[ed--]) {
                return false;
            }
        }
        return true;
    }
}