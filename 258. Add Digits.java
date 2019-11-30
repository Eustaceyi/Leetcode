class Solution {
    /**
     * key point abcd(number) = a*1000 + b*100 + c*10 + d
     * we want to get a+b+c+d = a*999+b*99+c*9 + a+b+c+d -> so we mod the number with 9
     * and the result of this should also be the same operation
     * and we need to keep in mind that if num is a multiply of 9, we should return 9
     * and if num is zero we should return zero
     * @param num
     * @return
     */
    public int addDigits(int num) {
        return num % 9 == 0 ? (num == 0 ? 0 : 9) : num % 9;
    }
}