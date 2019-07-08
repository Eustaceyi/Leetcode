class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        if not matrix or not matrix[0]:
            return False
        R = len(matrix)
        C = len(matrix[0])
        lo, hi = 0, R*C-1
        while lo<=hi:
            mid = (hi-lo)//2 + lo
            if matrix[mid//C][mid%C] == target:
                return True
            elif matrix[mid//C][mid%C] > target:
                hi = mid - 1
            else:
                lo = mid + 1
        return False