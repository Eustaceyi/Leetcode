/**
 * since java will overflow, so convert to long
 * and use a hash map for recording the ( position if the same number come again.
 */
class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        long n = (long)numerator;
        long d = (long)denominator;
        StringBuilder sb = new StringBuilder();
        HashMap<Long, Integer> map = new HashMap<>();
        if (n==0) return "0";
        boolean sign = true;
        if (n < 0 && d < 0) {
            d = -d;
            n = -n;
        } else if (n < 0) {
            n = -n;
            sign = false;
        } else if (d < 0) {
            d = -d;
            sign = false;
        }
        if (n % d == 0) {
            return (sign? "" : "-") + Long.toString(n/d);
        }
        String head = (sign? "" : "-") + Long.toString(n/d) + ".";
        n = n%d;
        while (n != 0) {
            if (map.containsKey(n)) {
                break;
            }
            map.put(n, sb.length());
            int count = 0;
            while (n < d) {
                n = n * 10;
                count++;
            }
            long div = n / d;
            while (count > 1) {
                sb.append(0);
                count--;
            }
            sb.append(div);
            n = n % d;
        }
        if (map.containsKey(n)) {
            sb.insert(map.get(n), "(");
            sb.append(')');
        }
        return head + sb.toString();
    }
}