class Solution:
    def mctFromLeafValues(self, arr: List[int]) -> int:
        '''
        dp solution Time O(n^3) Space O(n^2)
        we denote that dp[i][j] is the solution of sublist [i,j]
        and we can get that dp[i][j] = min(max(arr[i:k]) * max(arr[k+1:j]) + dp[i][k] + dp[k+1][j])
        kinda like brute force since we compute all tree
        '''
        n = len(arr)
        dp = [[0 for i in range(n)] for j in range(n)]
        for diff in range(1, n):
            for i in range(n):
                j = i+diff
                if j > n-1:
                    break
                currmin = 2**31
                for k in range(i,j):
                    temp = max(arr[i:k+1]) * max(arr[k+1:j+1]) + dp[i][k] + dp[k+1][j]
                    currmin = min(currmin, temp)
                dp[i][j] = currmin
        return dp[0][-1]

class Solution:
    def mctFromLeafValues(self, arr: List[int]) -> int:
        '''
        O(n) Time O(n) Space solution
        intuition is we will discard the smaller neighbor and never use it anymore,
        so we can use a stack for next greater element, 
        and then the cost of removing the smaller is itself * min(larger from left, larger from right)
        this implements the thought above
        '''
        ans = 0
        stack = [float('inf')]
        for a in arr:
            while stack[-1] <= a:
                temp = stack.pop()
                ans += temp * min(stack[-1], a)
            stack.append(a)
        while len(stack) > 2:
            ans += stack.pop() * stack[-1]
        return ans