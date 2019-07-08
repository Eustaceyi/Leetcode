class Solution:
    def setZeroes(self, matrix: List[List[int]]) -> None:
        """
        Do not return anything, modify matrix in-place instead.
        O(m+n) space and O(mn) time
        """
        row = set()
        column = set()
        for i in range(len(matrix)):
            for j in range(len(matrix[0])):
                if matrix[i][j] == 0:
                    row.add(i)
                    column.add(j)
        for i in range(len(matrix)):
            for j in range(len(matrix[0])):
                if i in row or j in column:
                    matrix[i][j] = 0

    def setZeroes(self, matrix: List[List[int]]) -> None:
        """
        Do not return anything, modify matrix in-place instead.
        O(1) space O(mn) time, is_col is for matrix[0][0] to see whether it is both column and row or just row
        """
        is_col = False
        R = len(matrix)
        C = len(matrix[0])
        for i in range(R):
            if matrix[i][0] == 0:
                is_col = True
            for j in range(1, C):
                if matrix[i][j] == 0:
                    matrix[0][j] = 0
                    matrix[i][0] = 0
        for i in range(1,R):
            for j in range(1,C):
                if matrix[0][j] == 0 or matrix[i][0] == 0:
                    matrix[i][j] = 0
        if matrix[0][0] == 0:
            for j in range(C):
                matrix[0][j] = 0  
        if is_col:
            for i in range(R):
                matrix[i][0] = 0