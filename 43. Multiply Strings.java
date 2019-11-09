class Solution {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) return "0";
        int[] prod = new int[num1.length()+num2.length()+2];
        for (int i=num1.length()-1; i>=0; i--) {
            int n1 = num1.charAt(i) - '0';
            for (int j=num2.length()-1; j>=0; j--) {
                int n2 = num2.charAt(j) - '0';
                prod[i+j+3] += n1 * n2;
            }
        }
        int carry = 0;
        for (int i=prod.length-1; i>=0; i--) {
            prod[i] += carry;
            carry = prod[i] / 10;
            prod[i] = prod[i] % 10;
        } 
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<prod.length; i++) {
            if (sb.length()==0 && prod[i]==0) {
                continue;
            }
            sb.append(prod[i]);
        }
        return sb.toString();
    }
}