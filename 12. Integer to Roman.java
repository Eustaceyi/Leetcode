class Solution {
    public String intToRoman(int num) {
        int[] Int = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] S = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<Int.length; i++) {
            int count = num / Int[i];
            for (int j=0; j<count; j++) {
                sb.append(S[i]);
            }
            num = num%Int[i];
        }
        return sb.toString();
    }
}