class Solution:
    def findCircleNum(self, M: List[List[int]]) -> int:
        def dfs(M, visited, i):
            for j in range(len(M)):
                if M[i][j] == 1 and not visited[j]:
                    visited[j] = 1
                    dfs(M, visited, j)
        
        visited = [0 for _ in range(len(M))]
        count = 0
        for i in range(len(M)):
            if not visited[i]:
                dfs(M, visited, i)
                count += 1
        return count