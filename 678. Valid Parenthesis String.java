/**
 * two pass solution
 * Time O(n)
 * Space O(1)
 */
class Solution {
    public boolean checkValidString(String s) {
        if (s==null || s.length()==0) {
            return true;
        }
        char[] sa = s.toCharArray();
        // we consider * as ( and we try to find if left is more in every step
        int left = 0;
        for (int i=0; i<sa.length; i++) {
            if (sa[i] == '(' || sa[i] == '*') {
                left++;
            } else {
                left--;
            }
            if (left < 0) return false;
        }
        // we consider * as ) and we try to find if right is more in every step
        int right = 0;
        for (int i=sa.length-1; i>=0; i--) {
            if (sa[i] == ')' || sa[i] == '*') {
                right++;
            } else {
                right--;
            }
            if (right < 0) return false;
        }
        return true;
    }
}

/**
 * not very optimal solution, but could work
 * Time O(n^2)
 * Space O(n)
 */
class Solution {
    public boolean checkValidString(String s) {
        if (s==null || s.length()==0) {
            return true;
        }
        Deque<Character> stack = new ArrayDeque<>();
        char[] sa = s.toCharArray();
        for (int i=0; i<sa.length; i++) {
            if (sa[i] == '*' || sa[i] == '(') {
                stack.push(sa[i]);
            } else {
                if (stack.isEmpty()) {
                    return false;
                } else {
                    int star = 0;
                    boolean match = false;
                    while (!stack.isEmpty()) {
                        if (stack.peek() == ')') {
                            break;
                        } else if (stack.peek() == '(') {
                            stack.pop();
                            match = true;
                            break;
                        } else {
                            stack.pop();
                            star++;
                        }
                    }
                    for (; star>0; star--) {
                        stack.push('*');
                    }
                    if (!match) {
                        stack.push(')');
                    }
                }
            }
        }
        int star = 0;
        int right = 0;
        while (!stack.isEmpty()) {
            char c = stack.pop();
            if (c == '(') {
                if (star <= 0) {return false;}
                else {star--;}
            } else if (c == ')') {
                right++;
            } else {
                if (right > 0) {right--;}
                else {star++;}
            }
        }
        return right == 0;
    }
}