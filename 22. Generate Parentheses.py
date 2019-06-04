class Solution:
    def generateParenthesis(self, n: int) -> list[str]:
        '''
        This uses a DFS helper method to solve the problem.
        '''
        if n == 0:
            return []
        left, right = n, n
        results = []
        self.helper(left, right, results, '')
        return results
        
    def helper(self, left, right, results, string):
        if right < left:
            return 
        if not left and not right:
            results.append(string)
            return
        if left:
            self.helper(left-1, right, results, string + '(')
        if right:
            self.helper(left, right-1, results, string + ')')