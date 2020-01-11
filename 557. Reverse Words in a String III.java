class Solution {
    public String reverseWords(String s) {
        char[] sarr = s.toCharArray();
        int st = 0;
        for (int i=0; i<sarr.length; i++) {
            if (sarr[i]==' ') {
                reverse(sarr, st, i-1);
                st = i+1;
            }
        }
        reverse(sarr, st, sarr.length-1);
        return String.valueOf(sarr);
    }
    
    private void reverse(char[] arr, int st, int ed) {
        while (st < ed) {
            char temp = arr[st];
            arr[st] = arr[ed];
            arr[ed] = temp;
            st++; ed--;
        }
    }
}