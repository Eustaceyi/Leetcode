class Solution {
    public int monotoneIncreasingDigits(int N) {
        char[] ca = Integer.toString(N).toCharArray();
        int index = ca.length;
        for (int i=ca.length-2; i>=0; i--) {
            // if we encounter a digit is larger than the next one, we should start building 9 from that
            // also node that we start from the end and this will help will breaking non-increasing numbers
            if (ca[i] > ca[i+1]) {
                index = i+1;
                ca[i]--;
            }
        }
        for (int i=index; i<ca.length; i++) {
            ca[i] = '9';
        }
        return Integer.parseInt(new String(ca));
    }
}