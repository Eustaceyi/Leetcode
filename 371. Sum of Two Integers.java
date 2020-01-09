class Solution {
    public int getSum(int a, int b) {
        if (a == 0) return b;
        if (b == 0) return a;

        while (b != 0) {
            int carry = a & b; // if some bit in a and b are all 1, this need to carry
            a = a ^ b; // this is finding out the bits that a and b are different
            b = carry << 1; // this is to make sure that carry is in the next bit
        } // and we loop this until there is no carry

        return a;
    }
}