class Solution:
    def searchMatrix(self, matrix, target):
        """
        :type matrix: List[List[int]]
        :type target: int
        :rtype: bool
        """
        if not matrix:
            return False
        for i in range(min(len(matrix[0]), len(matrix))):
            h = self.binary(matrix, target, i, False)
            v = self.binary(matrix, target, i, True)
            if h or v:
                return True
        return False
        
    def binary(self, matrix, target, i, is_ver):
        start = i
        if is_ver:
            if matrix[-1][i] < target:
                return False
            end = len(matrix)-1
        else:
            if matrix[i][-1] < target:
                return False
            end = len(matrix[0])-1
        while start <= end:
            mid = (start + end)//2
            if is_ver:
                if matrix[mid][i] == target:
                    return True
                elif matrix[mid][i] < target:
                    start = mid+1
                else:
                    end = mid-1
            else:
                if matrix[i][mid] == target:
                    return True
                elif matrix[i][mid] < target:
                    start = mid+1
                else:
                    end = mid-1
        return False