class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        boolean flag = true;
        String str = strs[0];
        for (int i=0; i<str.length(); i++) {
            char c = str.charAt(i);
            for (String s:strs) {
                if (i >= s.length() || s.charAt(i) != c) {
                    flag = false;
                    break;
                }
            }
            if (!flag) {
                return str.substring(0, i);
            }
        }
        return str;
    }
}