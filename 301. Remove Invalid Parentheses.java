/**
 * key point is find out how many to remove and we need to go through every situation
 * Time O(2^n) since worstly we may go through every char to find out whether include it or leave it
 * Space O(n) since stack will go as deep as n
 */
class Solution {
    public List<String> removeInvalidParentheses(String s) {
        Set<String> ans = new HashSet<>();
        int left = 0, right = 0;
        for (int i=0; i<s.length(); i++) {
            if (s.charAt(i) == '(') {
                left++;
            } else if (s.charAt(i) == ')') {
                right = left == 0? right+1:right;
                left = left == 0? left: left-1;
            }
        }
        helper(s, 0, 0, 0, left, right, new StringBuilder(), ans);
        return new ArrayList<>(ans);
    }
    private void helper(String s, int index, int leftCount, int rightCount, 
                       int leftRem, int rightRem, StringBuilder exp,
                        Set<String> ans) {
        if (index == s.length()) {
            // this is a valid combination
            if (leftRem == 0 && rightRem == 0) {
                ans.add(exp.toString());
            }
        } else {
            char c = s.charAt(index);
            int len = exp.length();
            // we skip this character by removing the ( or )
            if ((c == '(' && leftRem > 0) || (c == ')' && rightRem > 0)) {
                helper(s, index+1, leftCount, rightCount, 
                      leftRem - (c == '(' ? 1 : 0), 
                      rightRem - (c == ')' ? 1 : 0),
                      exp, ans);
            }
            exp.append(c);
            // skip non ( ) character
            if (c != '(' && c != ')') {
                helper(s, index+1, leftCount, rightCount, leftRem, rightRem, exp, ans);
            } else if (c == '(') {
                // we count this as valid and goes further
                helper(s, index+1, leftCount+1, rightCount, leftRem, rightRem, exp, ans);
            } else if (rightCount < leftCount) {
                // we count this as valid and goes further
                helper(s, index+1, leftCount, rightCount+1, leftRem, rightRem, exp, ans);
            }
            // backtracking
            exp.deleteCharAt(len);   
        }
    }
}