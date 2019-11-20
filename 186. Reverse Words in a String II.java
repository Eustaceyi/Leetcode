class Solution {
    public void reverseWords(char[] s) {
        reverse(s, 0, s.length-1);
        int w = 0;
        for (int i=0; i<s.length; i++) {
            if (s[i] == ' ') {
                reverse(s, w, i-1);
                w = i+1;
            }
        }
        reverse(s, w, s.length-1);
    }
    private void reverse(char[] s, int start, int end) {
        while (start < end) {
            char temp = s[start];
            s[start] = s[end];
            s[end] = temp;
            start++; end--;
        }
    }
}