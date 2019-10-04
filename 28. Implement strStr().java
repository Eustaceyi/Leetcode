class Solution {
    public int strStr(String haystack, String needle) {
        if (needle.length()==0) {
            return 0;
        }
        for (int i=0;i<haystack.length();i++) {
            int flag = 0;
            if (haystack.charAt(i) == needle.charAt(0)) {
                for (int j=1;j<needle.length();j++) {
                    if (i+j >= haystack.length() || haystack.charAt(i+j) != needle.charAt(j)) {
                        flag = 1;
                        break;
                    }
                }
                if (flag == 0) {
                    return i;
                }
            }
        }
        return -1;
    }
}