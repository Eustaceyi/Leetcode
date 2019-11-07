/**
 * Using stack One pass for chars several stack push pop operations
 * Time O(n) all chars of final string get in once and get out once
 * Space O(n) stack size may goes n
 */
class Solution {
    public String decodeString(String s) {
        if (s.length()==0) {return s;}
        Deque<String> stack = new ArrayDeque<>();
        StringBuilder num = new StringBuilder();
        StringBuilder chars = new StringBuilder();
        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                num.append(c);
            } else if (c == '[') {
                stack.push(num.toString());
                num = new StringBuilder();
                stack.push("[");
            } else if (c == ']') {
                String temp = stack.pop();
                while (!stack.peek().equals("[")) {
                    temp = stack.pop() + temp;
                }
                stack.pop();
                int times = Integer.parseInt(stack.pop());
                for (int j=0; j<times; j++) {
                    chars.append(temp);
                }
                stack.push(chars.toString());
                chars = new StringBuilder();
            } else {
                stack.push(c + "");
            }
        }
        String ans = "";
        while(!stack.isEmpty()) {
            ans = stack.pop() + ans;
        }
        return ans;
    }
}

/**
 * Recursion solution
 * Time O(n!) since each string we need to find out the ending ]
 * Space O(n) since run stack will goes to n
 */
class Solution {
    public String decodeString(String s) {
        return helper(s, 1);
    }
    
    private String helper(String s, int times) {
        StringBuilder sb = new StringBuilder();
        int idx = 0;
        int left = 0;
        while (idx < s.length()) {
            char c = s.charAt(idx);
            // if we found a digit, this indicates a "213[aaa]"
            if (Character.isDigit(c)) {
                int start = idx, end = idx+1;
                while (Character.isDigit(s.charAt(end))) {
                    end++;
                }
                int pint = Integer.parseInt(s.substring(start, end));
                start = end+1;
                end = end+1;
                left = 1;
                while (left > 0) {
                    if (s.charAt(end) == '[') {
                        left++;
                    } else if (s.charAt(end) == ']') {
                        left--;
                    }
                    end++;
                }
                String temp = helper(s.substring(start, end-1), pint);
                idx = end;
                sb.append(temp);
            } else { // other characters
                sb.append(c);
                idx++;
            }
        }
        String t = sb.toString();
        for (int i=0; i<times-1; i++) {
            sb.append(t);
        }
        return sb.toString();
    }
}