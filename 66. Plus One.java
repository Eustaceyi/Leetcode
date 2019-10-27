class Solution {
    public int[] plusOne(int[] digits) {
        if (digits==null || digits.length==0) {
            return digits;
        }
        int n = digits.length;
        int carry = digits[n-1] + 1;
        digits[n-1] = carry % 10;
        carry = carry / 10;
        int idx = n-2;
        while (idx >=0 && carry != 0) {
            carry = digits[idx] + carry;
            digits[idx] = carry % 10;
            carry /= 10;
            idx--;
        }
        if (carry != 0) {
            int[] ans = new int[n+1];
            ans[0] = carry;
            for (int i=1; i<n+1; i++) {
                ans[i] = digits[i-1];
            }
            return ans;
        } else {
            return digits;
        }
     }
}