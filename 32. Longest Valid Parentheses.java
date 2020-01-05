/**
 * stack one pass solution,
 * use stack to keep track of valid parentheses
 */
class Solution {
    public int longestValidParentheses(String s) {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(-1);
        int maxlen = 0;
        for (int i=0; i<s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                }
                maxlen = Math.max(maxlen, i-stack.peek());
            }
        }
        return maxlen;
    }
}

/**
 * without stack solution,
 * two pass,
 * 1. from left to right:
 * if we find left == right we record it,
 * if we find right is more, we need to discard previous
 * 2. from right to left:
 * if we find left == right we record it,
 * if we find left is more, we need to discard previous
 */
class Solution {
    public int longestValidParentheses(String s) {
        int left=0, right=0, maxlen=0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                left++;
            }
            if (c == ')') {
                right++;
            }
            if (left == right) {
                maxlen = Math.max(maxlen, 2*right);
            }
            if (right > left) {
                right = 0;
                left = 0;
            }
        }
        left = 0;
        right = 0;
        for (int i=s.length()-1; i>=0; i--) {
            char c = s.charAt(i);
            if (c == '(') {
                left++;
            }
            if (c == ')') {
                right++;
            }
            if (left == right) {
                maxlen = Math.max(maxlen, 2*right);
            }
            if (left > right) {
                right = 0;
                left = 0;
            }
        }
        return maxlen;
    }
}