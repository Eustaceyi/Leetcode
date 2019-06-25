class Solution:
    def generateMatrix(self, n: int) -> List[List[int]]:
        result = [[0 for _ in range(n)] for _ in range(n)]
        start = [0, 0]
        curr = 0
        dir = [[0,1], [1,0], [0,-1], [-1,0]]
        for i in range(n**2):
            result[start[0]][start[1]] = i+1
            if start[0]+dir[curr][0] >= n or start[0]+dir[curr][0] < 0 or start[1]+dir[curr][1] >= n\
                 or start[1]+dir[curr][1] < 0 or\
                      result[start[0]+dir[curr][0]][start[1]+dir[curr][1]] != 0:
                curr = (curr+1) % 4
            start[0] += dir[curr][0]
            start[1] += dir[curr][1]
        return result