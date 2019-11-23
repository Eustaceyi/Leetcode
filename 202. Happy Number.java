class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> seen = new HashSet<>();
        while (n != 1) {
            seen.add(n);
            int curr = 0;
            while (n != 0) {
                curr += (n%10) * (n%10);
                n = n/10;
            }
            n = curr;
            if (seen.contains(n)) {
                return false;
            }
        }
        return true;
    }
}