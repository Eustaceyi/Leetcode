class Solution:
    def spiralOrder(self, matrix: List[List[int]]) -> List[int]:
        if not matrix:
            return []
        result = []
        R, C = len(matrix), len(matrix[0])
        seen = [[False for i in range(C)] for _ in range(R)]
        direct = [(0,1), (1,0), (0,-1), (-1,0)]
        start = [0, 0]
        curr = 0
        for _ in range(R*C):
            result.append(matrix[start[0]][start[1]])
            seen[start[0]][start[1]] = True
            temp0 = start[0] + direct[curr][0]
            temp1 = start[1] + direct[curr][1]
            if temp0 >= R or temp1 >= C or temp0 < 0 or temp1 < 0 or seen[temp0][temp1]:
                curr = (curr + 1) % 4
            start[0] += direct[curr][0]
            start[1] += direct[curr][1]
        return result

class Solution:
    def spiralOrder(self, matrix: List[List[int]]) -> List[int]:
        if not matrix:
            return []
        result = []
        self.helper(matrix, result)
        return result
        
    def helper(self, matrix, result):
        if not matrix or not matrix[0]:
            return []
        R, C = len(matrix), len(matrix[0])
        direct = [(0,1), (1,0), (0,-1), (-1,0)]
        start = [0, 0]
        curr = 0
        if R > 1 and C > 1:
            itera = 2*R+2*C-4
        elif R > 1:
            itera = R
        else:
            itera = C
        for _ in range(itera):
            result.append(matrix[start[0]][start[1]])
            temp0 = start[0] + direct[curr][0]
            temp1 = start[1] + direct[curr][1]
            if temp0 >= R or temp1 >= C or temp0 < 0 or temp1 < 0:
                curr = (curr + 1) % 4
            start[0] += direct[curr][0]
            start[1] += direct[curr][1]
        self.helper([matrix[i][1:C-1] for i in range(1,R-1)], result)
        