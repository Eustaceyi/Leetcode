/**
 * Using a stack to store a monotonic increasing stack
 * Time O(n)
 * Space O(n)
 */
class Solution {
    public String removeKdigits(String num, int k) {
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : num.toCharArray()) {
            // this is to make sure it is monotonic and if we get rid of k we do not pop
            while (!stack.isEmpty() && k > 0 && stack.peek() > c) {
                stack.pop();
                k--;
            }
            stack.push(c);
        }
        // this is to pop out left increasing items
        for (int i=0; i<k; i++) {
            stack.pop();
        }
        
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            // remove leading zeros
            if (sb.length() == 0 && stack.peekLast() == '0') {
                stack.pollLast();
                continue;
            }
            sb.append(stack.pollLast());
        }
        return sb.length() > 0 ? sb.toString() : "0";
    }
}