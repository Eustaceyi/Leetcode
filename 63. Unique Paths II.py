class Solution:
    def uniquePathsWithObstacles(self, obstacleGrid: List[List[int]]) -> int:
        m = len(obstacleGrid)
        n = len(obstacleGrid[0])
        
        if obstacleGrid[0][0] == 1 or obstacleGrid[-1][-1] == 1:
            return 0
        
        result = [[0 for _ in range(n)] for _ in range(m)]
        result[0][0] = 1
        for i in range(1, n):
            result[0][i] = result[0][i-1] if obstacleGrid[0][i] == 0 else 0
        for i in range(1, m):
            result[i][0] = result[i-1][0] if obstacleGrid[i][0] == 0 else 0
        for i in range(1,m):
            for j in range(1,n):
                if obstacleGrid[i][j] == 0:
                    result[i][j] = result[i-1][j] + result[i][j-1]
        return result[-1][-1]