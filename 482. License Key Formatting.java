class Solution {
    public String licenseKeyFormatting(String S, int K) {
        char[] ca = S.replaceAll("-", "").toUpperCase().toCharArray();
        StringBuilder sb = new StringBuilder();
        int left = ca.length % K;
        int count = 0;
        for (int i=0; i<ca.length; i++) {
            if (left != 0 && i == left) {sb.append('-'); count = 0;}
            if (count==K) {
                sb.append('-');
                count = 0;
            }
            sb.append(ca[i]);
            count++;
        }
        return sb.toString();
    }
}