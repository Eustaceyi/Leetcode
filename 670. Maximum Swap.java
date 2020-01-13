class Solution {
    public int maximumSwap(int num) {
        Deque<Integer> stack = new ArrayDeque<>();
        char[] n = Integer.toString(num).toCharArray();
        int index = n.length;
        int maxindex = 0;
        for (int i=0; i<n.length; i++) {
            while (!stack.isEmpty() && n[stack.peek()] < n[i]) {
                int temp = stack.pop();
                if (temp < index) {
                    index = temp;
                    maxindex = i;
                }
            }
            if (n[i] >= n[maxindex]) {
                maxindex = i;
            }
            stack.push(i);
        }
        if (index == n.length) {return num;}
        char c = n[index];
        n[index] = n[maxindex];
        n[maxindex] = c;
        int ans = 0;
        for (char ch : n) {
            ans = ans * 10 + ch - '0';
        }
        return ans;
    }
}

/**
 * we use a array to store the last occurance of each digit
 * and we scan from the beginning, if we could find a larger number
 * behind itself, we could swap them.
 */
class Solution {
    public int maximumSwap(int num) {
        char[] A = Integer.toString(num).toCharArray();
        int[] last = new int[10];
        // finding the last occurance of the digits
        for (int i = 0; i < A.length; i++) {
            last[A[i] - '0'] = i;
        }
        // loop through all digits from beginning
        for (int i = 0; i < A.length; i++) {
            // this is to make sure that we are finding the largest one
            for (int d = 9; d > A[i] - '0'; d--) {
                if (last[d] > i) {
                    char tmp = A[i];
                    A[i] = A[last[d]];
                    A[last[d]] = tmp;
                    return Integer.valueOf(new String(A));
                }
            }
        }
        return num;
    }
}