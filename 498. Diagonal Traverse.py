class Solution:
    def findDiagonalOrder(self, matrix: List[List[int]]) -> List[int]:
        res = []
        if not matrix:
            return res
        r,c = len(matrix), len(matrix[0])
        for i in range(r+c-1):
            if i%2==0:
                for j in range(max(i+1-r,0),min(i,c-1)+1):
                    res.append(matrix[i-j][j])
            else:
                for j in range(max(i+1-c,0),min(i,r-1)+1):
                    res.append(matrix[j][i-j])
        return res