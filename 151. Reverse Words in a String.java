class Solution {
    public String reverseWords(String s) {
        String[] ss = s.trim().split(" ");
        int i = ss.length-1;
        StringBuilder sb = new StringBuilder();
        while (i >= 0) {
            if (ss[i].equals("")) {
                i--;
                continue;
            }
            sb.append(ss[i]);
            i--;
            if (i >= 0) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }
}