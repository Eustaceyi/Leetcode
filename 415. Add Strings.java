class Solution {
    public String addStrings(String num1, String num2) {
        if (num1 == null || num1.length() == 0) {
            return num2;
        }
        if (num2 == null || num2.length() == 0) {
            return num1;
        }
        int l1 = num1.length() - 1;
        int l2 = num2.length() - 1;
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        while (l1 >= 0 && l2 >= 0) {
            char c1 = num1.charAt(l1);
            char c2 = num2.charAt(l2);
            int temp = c1 - '0' + c2 - '0' + carry;
            sb.append(temp % 10);
            carry = temp / 10;
            l1--;
            l2--;
        }
        while (l1 >= 0) {
            char c1 = num1.charAt(l1);
            int temp = c1 - '0' + carry;
            sb.append(temp % 10);
            carry = temp / 10;
            l1--;
        }
        while (l2 >= 0) {
            char c2 = num2.charAt(l2);
            int temp = c2 - '0' + carry;
            sb.append(temp % 10);
            carry = temp / 10;
            l2--;
        }
        if (carry == 1) {
            sb.append(1);
        }
        return sb.reverse().toString();
    }
}