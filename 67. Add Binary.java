class Solution {
    public String addBinary(String a, String b) {
        int maxlen = Math.max(a.length(), b.length()) + 1;
        int[] res = new int[maxlen];
        int idx = 0, carry = 0;
        int la = a.length();
        int lb = b.length();
        while (idx < la && idx < lb) {
            char ca = a.charAt(la-1-idx);
            char cb = b.charAt(lb-1-idx);
            res[idx] = carry + (ca - '0') + (cb - '0');
            carry = res[idx] / 2;
            res[idx] = res[idx] % 2;
            idx++;
        }
        while (idx < la) {
            char ca = a.charAt(la-1-idx);
            res[idx] = carry + (ca - '0');
            carry = res[idx] / 2;
            res[idx] = res[idx] % 2;
            idx++;
        }
        while (idx < lb) {
            char cb = b.charAt(lb-1-idx);
            res[idx] = carry + (cb - '0');
            carry = res[idx] / 2;
            res[idx] = res[idx] % 2;
            idx++;
        }
        if (carry > 0) {
            res[idx] = carry;
            idx++;
        }
        StringBuilder sb = new StringBuilder();
        idx--;
        while (idx>=0) {
            sb.append(res[idx--]);
        }
        return sb.toString();
    }
}