class Solution:
    def longestValidParentheses(self, s: str) -> int:
        '''
        Using a stack to keep track the valid parentheses,
        when it comes to '(', we push it into the stack,
        when it comes to ')', we pop from the stack and we check if 
        the stack is empty, if empty, we put the index of this element into the stack
        and we calculate the length of the valid parentheses
        '''
        stack = [-1]
        maxlen = 0
        for i, char in enumerate(s):
            if char == '(':
                stack.append(i)
            else:
                stack.pop(-1)
                if not stack:
                    stack.append(i)
                maxlen = max(maxlen, i-stack[-1])
        return maxlen

class Solution:
    def longestValidParentheses(self, s: str) -> int:
        '''
        https://leetcode.com/articles/longest-valid-parentheses/#approach-2-using-dynamic-programming
        cannot understand approach 4, try using stack is easiest to understand
        '''
        maxlen = 0
        dp = [0 for _ in s]
        for i in range(1, len(s)):
            if s[i] == ')':
                if s[i-1] == '(':
                    dp[i] = dp[i-2]+2
                elif i - dp[i-1] > 0 and s[i-dp[i-1]-1] == '(':
                    dp[i] = dp[i-1] +  dp[i - dp[i - 1] - 2] + 2
                maxlen = max(maxlen, dp[i])
        return maxlen
                    